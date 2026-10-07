# ASP.NET Core Web API: Exam & Technical Interview Prep Guide

**Topics covered:**
1. Serialization & Deserialization
2. EF Core, DbContext, DbSet & Navigation Properties
3. API Versioning (URL vs Header)
4. Routing (Attribute vs Conventional)
5. Rapid-fire Q&A, pitfalls, and cheat sheets

---

## 0. Big Picture: The Full Request Lifecycle

```
CLIENT (React / Postman)
   │  HTTP request + JSON
   ▼
Routing  ──► picks Controller + Action
   ▼
Model Binding + JSON Deserialization ──► DTO object
   ▼
Controller ► Service ► Repository ► EF Core (DbContext) ► Database
   ▼
DTO object
   ▼
JSON Serialization
   ▼
HTTP response ──► CLIENT
```

**One-line memory:**
- **POST:** JSON → Deserialize → DTO → Controller → Service → Repository → DB
- **GET:** DB → Repository → Service → DTO → Serialize → JSON → Client

---

# PART 1: Serialization & Deserialization

## 1.1 Definitions

| Term | Meaning | Direction |
|---|---|---|
| **Serialization** | Convert a C# object into a transferable/storable format (JSON, XML) | Object → JSON |
| **Deserialization** | Convert JSON/XML back into a C# object | JSON → Object |

**Memory trick:** *Serialize = Send/Store. Deserialize = Receive/Read.*

## 1.2 Basic Code (System.Text.Json)

```csharp
public class Student
{
    public int Id { get; set; }
    public string Name { get; set; }
    public int Age { get; set; }
}
```

**Serialize:**
```csharp
using System.Text.Json;

var student = new Student { Id = 1, Name = "Rahul", Age = 22 };
string json = JsonSerializer.Serialize(student);
// {"Id":1,"Name":"Rahul","Age":22}
```

**Deserialize:**
```csharp
string json = """{ "Id": 1, "Name": "Rahul", "Age": 22 }""";
Student student = JsonSerializer.Deserialize<Student>(json);
Console.WriteLine(student.Name); // Rahul
```

**Collections:**
```csharp
string json = JsonSerializer.Serialize(listOfStudents);              // → JSON array
var students = JsonSerializer.Deserialize<List<Student>>(json);      // ← JSON array
```

## 1.3 Serialization vs Deserialization Table

| Feature | Serialization | Deserialization |
|---|---|---|
| Direction | Object → Data | Data → Object |
| Input | C# object | JSON/XML |
| Output | JSON/XML | C# object |
| Method | `Serialize()` | `Deserialize<T>()` |
| Used when | Sending/storing | Receiving/reading |

## 1.4 Sync vs Async

```csharp
string json = JsonSerializer.Serialize(student);                 // in-memory
await JsonSerializer.SerializeAsync(stream, student);            // stream-based
var obj = await JsonSerializer.DeserializeAsync<Student>(stream);
```

In controllers you rarely call these manually. ASP.NET Core's **JSON formatters** do it automatically.

## 1.5 How It Works in Web API

**Incoming request (Deserialization):**
```csharp
[HttpPost]
public IActionResult AddStudent(StudentDto student) => Ok(student);
```
Body `{ "name": "Rahul", "email": "rahul@gmail.com", "age": 22 }` is deserialized into `StudentDto`.

**Outgoing response (Serialization):**
```csharp
[HttpGet]
public IActionResult GetStudent() => Ok(new StudentDto { Id = 1, Name = "Rahul", Age = 22 });
```
The object is serialized to JSON `{ "id":1, "name":"Rahul", "age":22 }`.

## 1.6 JSON Naming (camelCase vs PascalCase)

| Context | Default naming |
|---|---|
| `JsonSerializer.Serialize()` used manually | **PascalCase** (`StudentId`) |
| ASP.NET Core Web API (MVC formatter) | **camelCase** (`studentId`) |

> **Exam trap:** The camelCase default comes from ASP.NET Core's *web defaults*, not from raw `JsonSerializer`. Also, ASP.NET Core deserialization is **case-insensitive** by default.

Customize:
```csharp
builder.Services.AddControllers().AddJsonOptions(o =>
{
    o.JsonSerializerOptions.PropertyNamingPolicy = null; // keep PascalCase
});
```

Useful attributes: `[JsonPropertyName("full_name")]`, `[JsonIgnore]`.

## 1.7 System.Text.Json vs Newtonsoft.Json

| Feature | System.Text.Json | Newtonsoft.Json |
|---|---|---|
| Built into .NET | ✅ | ❌ (NuGet package) |
| Default in ASP.NET Core | ✅ | ❌ |
| Performance | Generally faster, lower allocations | Very good |
| Namespace | `System.Text.Json` | `Newtonsoft.Json` |
| Serialize | `JsonSerializer.Serialize()` | `JsonConvert.SerializeObject()` |
| Deserialize | `JsonSerializer.Deserialize<T>()` | `JsonConvert.DeserializeObject<T>()` |
| Best for | Modern apps | Legacy compatibility, advanced features |

## 1.8 Why Use DTOs (Security + Contract Control)

Never return entities containing sensitive fields (e.g., `Password`).

```csharp
public class User            // Entity
{
    public int UserId { get; set; }
    public string FullName { get; set; }
    public string Email { get; set; }
    public string Password { get; set; }   // sensitive
}

public class UserResponseDto // DTO
{
    public int UserId { get; set; }
    public string FullName { get; set; }
    public string Email { get; set; }
}
```
Serialization of the DTO omits `Password`. DTOs also help prevent **over-posting** and decouple the DB schema from the API contract.

## 1.9 Model Binding vs Deserialization

| Concept | Role |
|---|---|
| **Model Binding** | Maps request data (route, query, form, body, headers) to action parameters |
| **Deserialization** | Converts structured data (JSON) into a .NET object |

JSON deserialization participates in binding a complex **`[FromBody]`** parameter (with `[ApiController]`, complex types are inferred as `[FromBody]`).

## 1.10 Interview Q&A: Serialization

**Q1. What is serialization?**
Converting a C# object into a format like JSON so it can be transmitted or stored.

**Q2. What is deserialization?**
Converting serialized data such as JSON back into a C# object.

**Q3. What does ASP.NET Core use for JSON by default?**
`System.Text.Json`.

**Q4. What happens when React sends JSON to a Web API?**
JSON → Deserialization → DTO → Controller.

**Q5. What happens when a Web API returns an object?**
Object/DTO → Serialization → JSON → HTTP response.

**Q6. Serialization vs model binding?**
Model binding maps request data to controller parameters; serialization/deserialization converts objects to/from formats like JSON. JSON deserialization commonly participates in binding `[FromBody]` parameters.

**Q7. Why use DTOs instead of returning entities?**
Security (hide sensitive fields), versioning flexibility, avoiding circular references, smaller payloads, and decoupling DB schema from API contract.

---

# PART 2: EF Core, DbContext & Navigation Properties

## 2.1 Architecture Flow

```
Web API ► Service ► EF Core ► DbContext ► SQL Server ► Database
```

## 2.2 What is EF Core?

**EF Core** = Microsoft's cross-platform **ORM (Object-Relational Mapper)** for .NET. You work with C# classes/LINQ instead of writing SQL for every operation.

```csharp
var students = await _context.Students.ToListAsync();  // translated to SELECT * FROM Students
```

```
C# Class ► EF Core ► Database Table
```

## 2.3 What is DbContext?

The **bridge/session** between your app and the database. It manages:
- Connection/configuration
- Entity sets (`DbSet<T>`)
- Querying, inserting, updating, deleting
- **Change tracking**
- Relationships
- `SaveChanges()` and transactions

```csharp
public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

    public DbSet<Student> Students { get; set; }
    public DbSet<Department> Departments { get; set; }
}
```

## 2.4 What is DbSet\<T\>?

Represents a collection of entities EF Core can query and modify (typically maps to a table).
`_context.Students` → access `Student` entities.

## 2.5 CRUD with DbContext

```csharp
// READ ALL
var students = await _context.Students.ToListAsync();

// READ BY PK
var student = await _context.Students.FindAsync(1);

// CREATE
_context.Students.Add(new Student { Name = "Rahul" });
await _context.SaveChangesAsync();

// UPDATE
var s = await _context.Students.FindAsync(1);
if (s != null) { s.Name = "Amit"; await _context.SaveChangesAsync(); }

// DELETE
var d = await _context.Students.FindAsync(1);
if (d != null) { _context.Students.Remove(d); await _context.SaveChangesAsync(); }
```

## 2.6 SaveChanges()

`Add()`/`Remove()`/property edits only mark changes in the tracker. **Nothing hits the DB until `SaveChanges()` / `SaveChangesAsync()`.**

```
Add() ► EF tracks change ► SaveChanges() ► SQL generated ► DB updated
```

## 2.7 Change Tracking

EF Core snapshots entities it loads. If you modify a tracked entity and call `SaveChanges()`, it auto-generates the `UPDATE`. You don't write SQL.

## 2.8 AsNoTracking()

```csharp
var students = await _context.Students.AsNoTracking().ToListAsync();
```
- Skips change-tracking overhead → faster, less memory.
- Use for **read-only GET** queries.
- Don't use it if you plan to modify and save those entities.

## 2.9 Navigation Properties

A **navigation property** lets you move from one entity to a related entity.

### Foreign Key vs Navigation Property

```csharp
public int DepartmentId { get; set; }        // Foreign Key (stores the ID)
public Department Department { get; set; }   // Navigation Property (accesses the object)
```

| | Foreign Key | Navigation Property |
|---|---|---|
| Stores | Key value (e.g., `10`) | Reference to related object |
| Purpose | Database-level relationship | Object-level navigation |
| Example | `DepartmentId` | `student.Department` |

### Types

| Type | Points to | Example |
|---|---|---|
| **Reference navigation** | One related entity | `public Department Department { get; set; }` |
| **Collection navigation** | Many related entities | `public ICollection<Student> Students { get; set; }` |

## 2.10 Relationship Types

### One-to-Many (most common)
```csharp
public class Department
{
    public int DepartmentId { get; set; }
    public string Name { get; set; }
    public ICollection<Student> Students { get; set; } = new List<Student>();
}

public class Student
{
    public int StudentId { get; set; }
    public string Name { get; set; }
    public int DepartmentId { get; set; }          // FK
    public Department Department { get; set; }     // Reference nav
}
```

### One-to-One
```csharp
public class User        { public int UserId { get; set; } public UserProfile Profile { get; set; } }
public class UserProfile { public int UserProfileId { get; set; } public int UserId { get; set; } public User User { get; set; } }
```

### Many-to-Many
```csharp
public class Student { public int StudentId { get; set; } public ICollection<Course> Courses { get; set; } }
public class Course  { public int CourseId  { get; set; } public ICollection<Student> Students { get; set; } }
```
Modern EF Core (5+) supports this directly (implicit join table). Use an explicit join entity (e.g., `Enrollment`) when you need extra columns like `EnrolledOn` or `Grade`.

## 2.11 Loading Related Data

| Method | Purpose |
|---|---|
| `Include()` | Eager-load a related entity/collection |
| `ThenInclude()` | Load a deeper level after `Include()` |

```csharp
var students = await _context.Students
    .Include(s => s.Department)
        .ThenInclude(d => d.Faculty)
    .ToListAsync();
```

> **Note:** Without `Include()`, navigation properties are typically `null`/empty unless lazy loading is configured. Loading strategies: **Eager** (`Include`), **Explicit** (`Entry().Reference().Load()`), **Lazy** (needs proxies package).

## 2.12 Fluent API Relationship Configuration

```csharp
protected override void OnModelCreating(ModelBuilder modelBuilder)
{
    modelBuilder.Entity<Student>()
        .HasOne(s => s.Department)       // Student has one Department
        .WithMany(d => d.Students)       // Department has many Students
        .HasForeignKey(s => s.DepartmentId);
}
```

Read it aloud: *Student → HasOne Department → WithMany Students → FK = DepartmentId.*

## 2.13 DbContext with Dependency Injection

**Program.cs:**
```csharp
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));
```

**Injection:**
```csharp
public class StudentController : ControllerBase
{
    private readonly AppDbContext _context;
    public StudentController(AppDbContext context) => _context = context;
}
```

## 2.14 DbContext Lifetime

- Registered as **Scoped** by default → **one instance per HTTP request**.
- **Never** register as Singleton (not thread-safe, stale tracked data).
- `DbContext` is **not thread-safe**.

## 2.15 Cheat Table

| Concept | Meaning |
|---|---|
| EF Core | ORM |
| DbContext | Session/bridge between app and DB |
| DbSet | Entity set (≈ table) |
| Entity | C# class mapped to a table |
| Primary Key | Uniquely identifies a record |
| Foreign Key | Links related tables |
| Navigation Property | Navigate between related entities |
| Include() | Eager loads related data |
| ThenInclude() | Loads deeper levels |
| SaveChanges() | Persists changes |
| Change Tracking | Detects entity modifications |
| AsNoTracking() | Read-only, no tracking |

## 2.16 Interview Q&A: EF Core

**Q1. What is EF Core?**
Microsoft's cross-platform ORM for .NET allowing interaction with relational databases using C# objects, LINQ, and DbContext instead of hand-written SQL for every operation.

**Q2. What is DbContext?**
The primary EF Core class that manages entity sets, DB interaction, change tracking, relationships, and saving changes.

**Q3. What is DbSet?**
`DbSet<T>` represents an entity set that EF Core can query and modify, commonly corresponding to a table.

**Q4. What is a navigation property?**
A property on an entity representing a relationship with another entity, enabling navigation between related objects.

**Q5. Foreign key vs navigation property?**
FK stores the related entity's key value; navigation property gives object-level access to the related entity.

**Q6. What does Include() do?**
Tells EF Core to load related navigation-property data as part of the query.

**Q7. What is the default DbContext lifetime?**
Scoped (per HTTP request).

**Q8. When to use AsNoTracking()?**
For read-only queries where you won't update the returned entities.

**Q9. What does SaveChanges() return?**
The number of rows affected in the database.

**Q10. Code-First vs Database-First?**
Code-First: define C# classes and generate DB through migrations. Database-First: scaffold classes from an existing DB (`Scaffold-DbContext`).

**One-line answer:**
> EF Core is the ORM, DbContext manages interaction between the app and database, DbSet represents entity sets, and navigation properties represent relationships such as Student → Department.

---

# PART 3: API Versioning

## 3.1 What & Why

**API Versioning** = maintaining multiple versions of an API so existing clients keep working while new clients use updated contracts.

```
/api/v1/students   → { "id": 1, "name": "Rahul" }
/api/v2/students   → { "studentId": 1, "fullName": "Rahul Patel" }
```
Without versioning, renaming `name` → `fullName` would **break old clients**.

## 3.2 URL Versioning

Version is part of the URL.

```csharp
[ApiController]
[Route("api/v1/students")]
public class StudentV1Controller : ControllerBase
{
    [HttpGet] public IActionResult Get() => Ok("Version 1");
}

[ApiController]
[Route("api/v2/students")]
public class StudentV2Controller : ControllerBase
{
    [HttpGet] public IActionResult Get() => Ok("Version 2");
}
```

> **Watch out:** `[Route("api/v2/[controller]")]` on `StudentV2Controller` yields `/api/v2/StudentV2`. Use explicit route strings (or versioned namespaces) to keep URLs clean.

**Pros:** visible, easy to test (browser/Postman/Swagger), easy to document, clear for clients.
**Cons:** URL changes between versions; version "pollutes" the resource URI.

## 3.3 Header Versioning

Version is sent via an HTTP header; **URL stays the same**.

```
GET /api/students
X-API-Version: 2
```

**Pros:** clean URLs.
**Cons:** less visible, harder to test in a browser, Swagger setup needs more configuration.

## 3.4 Comparison

| Feature | URL Versioning | Header Versioning |
|---|---|---|
| Version location | URL | HTTP header |
| Example | `/api/v1/students` | `/api/students` + `X-API-Version: 1` |
| Visibility | ✅ High | ❌ Lower |
| URL changes per version | Yes | No |
| Browser testing | Easy | Needs a tool |
| Swagger | Straightforward | More config |
| Caching | Simple (different URLs) | Needs `Vary` header |

**Other strategies:** Query string (`?api-version=1.0`), Media type (`Accept: application/json;v=2`).

## 3.5 Library Setup (Asp.Versioning)

Versioning isn't fully built into the base framework. The common choice is the **ASP.NET API Versioning** package (`Asp.Versioning.Mvc` / older `Microsoft.AspNetCore.Mvc.Versioning`).

```csharp
builder.Services.AddApiVersioning(options =>
{
    options.DefaultApiVersion = new ApiVersion(1, 0);
    options.AssumeDefaultVersionWhenUnspecified = true;
    options.ReportApiVersions = true;   // adds api-supported-versions header
    // Choose how version is read:
    options.ApiVersionReader = ApiVersionReader.Combine(
        new UrlSegmentApiVersionReader(),
        new HeaderApiVersionReader("X-API-Version"),
        new QueryStringApiVersionReader("api-version"));
});
```

Controller usage:
```csharp
[ApiVersion("1.0")]
[Route("api/v{version:apiVersion}/students")]
public class StudentsController : ControllerBase { }
```

> Exact package/API surface varies by library version. Know the **concept** first.

## 3.6 Interview Q&A: Versioning

**Q1. What is API versioning?**
Maintaining multiple API versions so existing clients continue working while new ones use updated functionality or contracts.

**Q2. What is URL versioning?**
Putting the version in the URL path, e.g., `/api/v1/students`.

**Q3. What is header versioning?**
Specifying the version through an HTTP request header while keeping the URL unchanged.

**Q4. Which is better?**
No universal winner. URL versioning is simplest/most discoverable; header versioning keeps URLs clean. Choose based on team and client needs.

**Q5. When should you create a new version?**
On **breaking changes** (removed/renamed fields, changed types, changed behavior). Non-breaking additions generally don't need a new version.

---

# PART 4: Routing

## 4.1 What is Routing?

Routing decides **which controller action handles an incoming HTTP request**.

```
GET /api/Student/10 ► Routing ► StudentController ► GetStudentById(10)
```

## 4.2 Conventional Routing

Route pattern defined **centrally** (usually `Program.cs`). Controller/action names drive the URL.

```csharp
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");
```

| Segment | Meaning |
|---|---|
| `{controller}` | Controller name |
| `{action}` | Action method name |
| `{id?}` | Optional parameter |
| `=Home` / `=Index` | Default values |

Example for Web API-style conventional routing:
```csharp
app.MapControllerRoute(name: "default", pattern: "api/{controller}/{action}/{id?}");
```
`/api/Student/GetById/10` → `StudentController.GetById(10)`.

**Best suited for:** traditional **MVC apps with Views**.

## 4.3 Attribute Routing

Routes defined **directly on controllers/actions** with attributes: `[Route]`, `[HttpGet]`, `[HttpPost]`, `[HttpPut]`, `[HttpDelete]`, `[HttpPatch]`.

```csharp
[ApiController]
[Route("api/[controller]")]
public class StudentController : ControllerBase
{
    [HttpGet]                    public IActionResult GetAll() => Ok();
    [HttpGet("{id:int}")]        public IActionResult GetById(int id) => Ok(id);
    [HttpPost]                   public IActionResult Add(StudentDto dto) => Created("", dto);
    [HttpPut("{id:int}")]        public IActionResult Update(int id, StudentDto dto) => NoContent();
    [HttpDelete("{id:int}")]     public IActionResult Delete(int id) => NoContent();
}
```

| HTTP | URL | Action |
|---|---|---|
| GET | `/api/student` | GetAll |
| GET | `/api/student/10` | GetById |
| POST | `/api/student` | Add |
| PUT | `/api/student/10` | Update |
| DELETE | `/api/student/10` | Delete |

> **Important:** Controllers with `[ApiController]` **require attribute routing**. Conventional routes aren't supported for them.

### `[controller]` token
`[Route("api/[controller]")]` on `StudentController` → `/api/Student` (the "Controller" suffix is dropped). Also available: `[action]`, `[area]`.

### Custom paths (action name needn't appear)
```csharp
[Route("api/students")]
public class StudentController : ControllerBase
{
    [HttpGet("all")]            public IActionResult GetAll() => Ok();        // /api/students/all
    [HttpGet("details/{id}")]   public IActionResult Get(int id) => Ok();     // /api/students/details/10
}
```

## 4.4 Route Constraints

| Constraint | Example |
|---|---|
| int | `{id:int}` |
| long | `{id:long}` |
| guid | `{id:guid}` |
| bool | `{active:bool}` |
| min / max | `{id:min(1)}`, `{id:max(100)}` |
| range | `{id:range(1,100)}` |
| length | `{code:length(5)}` |
| minlength | `{name:minlength(3)}` |
| combined | `{id:int:min(1)}` |

`/api/student/abc` fails to match `{id:int}`, typically giving a **404** for that endpoint.

## 4.5 Route Parameters vs Query Parameters

| Type | Example | Use for |
|---|---|---|
| **Route** | `GET /api/students/10` | Identifying a specific resource |
| **Query** | `GET /api/students?page=1&pageSize=10` | Pagination, search, filtering, sorting |

```csharp
[HttpGet("{id}")]
public IActionResult Get(int id, string? name) => Ok();   // /api/Student/10?name=Mohit

[HttpGet]
public IActionResult GetAll([FromQuery] int page, [FromQuery] int pageSize) => Ok();
```

## 4.6 Conventional vs Attribute Routing

| Feature | Conventional | Attribute |
|---|---|---|
| Defined | Centrally (`Program.cs`) | On controller/action |
| Uses controller/action names in URL | Usually yes | Not necessarily |
| Flexibility | Lower | Higher |
| Fine-grained control | Limited | Excellent |
| Common in MVC (views) | ✅ | ✅ |
| Common in Web API | ❌ Rare | ⭐ Standard |
| REST friendliness | Possible | Excellent |
| Complex URLs | Harder | Easier |
| Route visible beside action | ❌ | ✅ |
| `[ApiController]` support | ❌ | ✅ Required |

## 4.7 Mixing Versioning + Attribute Routing

```csharp
[ApiController]
[Route("api/v1/students")]
public class StudentV1Controller : ControllerBase { /* ... */ }
```

## 4.8 Interview Q&A: Routing

**Q1. What is routing?**
The process ASP.NET Core uses to match an incoming HTTP request to an endpoint/controller action.

**Q2. What is conventional routing?**
Uses a predefined pattern like `{controller}/{action}/{id?}` to pick the controller and action.

**Q3. What is attribute routing?**
Defines routes directly on controllers/actions using attributes like `[Route]`, `[HttpGet]`.

**Q4. Which is commonly used in Web API?**
Attribute routing, because it gives explicit, precise control and clean REST endpoints.

**Q5. Can you mix both?**
Yes in MVC apps, but an action with attribute routes isn't reached via conventional routes.

**Q6. Where is routing middleware configured?**
`app.UseRouting()` + `app.MapControllers()` (or `MapControllerRoute` for conventional) in `Program.cs`. In minimal hosting, routing is added implicitly.

**Q7. Route vs query parameter?**
Route identifies a resource (`/students/10`); query refines/filters a collection (`?page=1`).

---

# PART 5: Rapid-Fire Revision

## 5.1 Core Memory Cards

```
SERIALIZATION     = C# Object  ► JSON   (send / store)
DESERIALIZATION   = JSON       ► Object (receive / read)

EF CORE           = ORM
DbContext         = session/bridge to the DB
DbSet<T>          = table / entity set
Navigation Prop   = object-level relationship
Foreign Key       = ID-level relationship

URL VERSIONING    = /api/v1/students
HEADER VERSIONING = X-API-Version: 1

ATTRIBUTE ROUTING    = [HttpGet("{id}")]
CONVENTIONAL ROUTING = {controller}/{action}/{id?}

GET=Read  POST=Create  PUT=Update  DELETE=Delete
```

## 5.2 HTTP Methods & Status Codes

| Method | Purpose | Idempotent? | Typical success code |
|---|---|---|---|
| GET | Read | ✅ | 200 OK |
| POST | Create | ❌ | 201 Created |
| PUT | Replace/update | ✅ | 200 / 204 |
| PATCH | Partial update | Not guaranteed | 200 / 204 |
| DELETE | Remove | ✅ | 204 No Content |

| Code | Meaning |
|---|---|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request (validation/binding failure) |
| 401 | Unauthorized (not authenticated) |
| 403 | Forbidden (authenticated, no permission) |
| 404 | Not Found |
| 409 | Conflict |
| 500 | Internal Server Error |

## 5.3 Common Pitfalls (Likely Exam Traps)

1. **Forgetting `SaveChangesAsync()`**: changes never persist.
2. **Missing `Include()`**: navigation property is `null`.
3. **Returning entities directly**: leaks sensitive fields; can cause circular reference errors in serialization (`Department ↔ Students`).
4. **Registering DbContext as Singleton**: breaks thread-safety.
5. **Using `AsNoTracking()` then expecting updates to save**: they won't.
6. **`[Route("api/v2/[controller]")]` on `StudentV2Controller`**: yields `/api/v2/StudentV2`, not `/students`.
7. **Raw `JsonSerializer` is PascalCase; ASP.NET Core output is camelCase**.
8. **Putting `[ApiController]` with conventional routing**: not supported; use attribute routes.
9. **Using `FindAsync` with `Include`**: `FindAsync` can't be chained with `Include`; use `FirstOrDefaultAsync` instead.
10. **Not null-checking** after `FindAsync` (returns `null` if missing).

## 5.4 Handling Circular References (Common Follow-up)

Problem: `Department.Students` ↔ `Student.Department` causes a serialization cycle.

Fixes:
- **Best:** return **DTOs** (no cycles).
- Or configure:
```csharp
builder.Services.AddControllers().AddJsonOptions(o =>
    o.JsonSerializerOptions.ReferenceHandler = ReferenceHandler.IgnoreCycles);
```

## 5.5 Mini Quiz (Self-Test)

1. Which method converts JSON → object? → `Deserialize<T>()`
2. Default JSON library in ASP.NET Core? → `System.Text.Json`
3. What stores the related entity's ID? → Foreign Key
4. What loads related data eagerly? → `Include()`
5. Default DbContext lifetime? → Scoped
6. Which routing is preferred for REST APIs? → Attribute routing
7. What does `{id:int}` do? → Restricts `id` to an integer
8. Where does header versioning put the version? → HTTP request header
9. Which method commits tracked changes to the DB? → `SaveChanges()` / `SaveChangesAsync()`
10. What does `AsNoTracking()` do? → Disables change tracking for read-only queries

## 5.6 "Explain in 30 Seconds" Scripts

**Serialization:** "Serialization converts a C# object to JSON so it can be sent over HTTP or stored. Deserialization reverses it. ASP.NET Core does both automatically using System.Text.Json: deserializing request bodies into DTOs and serializing return values into responses."

**EF Core/DbContext:** "EF Core is an ORM that maps C# classes to tables. DbContext is the session that tracks entities and saves changes. DbSet represents a table. Navigation properties model relationships, and Include() eagerly loads them."

**Versioning:** "API versioning lets old and new clients coexist. URL versioning puts the version in the path, header versioning keeps the URL clean and reads the version from a header. I'd version only on breaking changes."

**Routing:** "Routing maps an HTTP request to a controller action. Conventional routing uses a central pattern, common in MVC. Attribute routing uses `[Route]` and `[HttpGet]` on the controller, and it's the standard for REST APIs."

---

**Final end-to-end chain to memorize:**

```
POST: JSON ► Deserialization ► DTO ► Controller ► Service ► Repository ► DbContext ► Database
GET:  Database ► DbContext ► Repository ► Service ► DTO ► Serialization ► JSON ► Client
```
