# React Hooks — Complete Guide

A simple, example-driven reference for every major React Hook, plus the most-used React Router hooks.

---

## Table of Contents

1. [State Hooks](#state-hooks)
   - [useState](#usestate)
   - [useReducer](#usereducer)
2. [Context Hook](#context-hook)
   - [useContext](#usecontext)
3. [Ref Hooks](#ref-hooks)
   - [useRef](#useref)
   - [useImperativeHandle](#useimperativehandle)
4. [Effect Hooks](#effect-hooks)
   - [useEffect](#useeffect)
   - [useLayoutEffect](#uselayouteffect)
   - [useInsertionEffect](#useinsertioneffect)
5. [Performance Hooks](#performance-hooks)
   - [useMemo](#usememo)
   - [useCallback](#usecallback)
   - [useTransition](#usetransition)
   - [useDeferredValue](#usedeferredvalue)
6. [Other React Hooks](#other-react-hooks)
   - [useId](#useid)
   - [useSyncExternalStore](#usesyncexternalstore)
   - [useDebugValue](#usedebugvalue)
7. [React Router Hooks](#react-router-hooks)
   - [useNavigate](#usenavigate)
   - [useParams](#useparams)
   - [useLocation](#uselocation)
   - [useSearchParams](#usesearchparams)
   - [useOutletContext](#useoutletcontext)

---

## State Hooks

### useState

**Simple explanation:**
`useState` gives a component its own memory. Every time you call the "setter" function, React re-renders the component with the new value. Think of it as a sticky note component keeps checking — when you write something new on it, the component redraws itself.

**Syntax:**
```jsx
const [state, setState] = useState(initialValue);
```

**Example:**
```jsx
import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>Click me</button>
    </div>
  );
}
```

**Real-world use case:**
- Tracking a shopping cart item count.
- Toggling a modal/dialog open or closed.
- Storing form input values (name, email, etc.).

---

### useReducer

**Simple explanation:**
`useReducer` is like `useState` but for more complex state logic. Instead of setting state directly, you "dispatch" an action (a small message describing what happened), and a `reducer` function decides how the state should change. It's useful when state has multiple sub-values or the next state depends on the previous one in complex ways.

**Syntax:**
```jsx
const [state, dispatch] = useReducer(reducer, initialState);

function reducer(state, action) {
  switch (action.type) {
    case "increment":
      return { count: state.count + 1 };
    default:
      return state;
  }
}
```

**Example:**
```jsx
import { useReducer } from "react";

function reducer(state, action) {
  switch (action.type) {
    case "increment":
      return { count: state.count + 1 };
    case "decrement":
      return { count: state.count - 1 };
    default:
      throw new Error("Unknown action");
  }
}

function Counter() {
  const [state, dispatch] = useReducer(reducer, { count: 0 });

  return (
    <div>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: "increment" })}>+</button>
      <button onClick={() => dispatch({ type: "decrement" })}>-</button>
    </div>
  );
}
```

**Real-world use case:**
- Managing a shopping cart with add/remove/update-quantity actions.
- Complex forms with many fields and validation rules.
- A multi-step wizard/checkout flow where state transitions are well-defined.

---

## Context Hook

### useContext

**Simple explanation:**
Normally, data is passed from parent to child using props — but that becomes painful if you need to pass data through many layers ("prop drilling"). `useContext` lets a component "tune in" directly to shared data (like a radio station), no matter how deep it is in the tree.

**Syntax:**
```jsx
const ThemeContext = createContext(defaultValue);

const value = useContext(ThemeContext);
```

**Example:**
```jsx
import { createContext, useContext } from "react";

const ThemeContext = createContext("light");

function App() {
  return (
    <ThemeContext.Provider value="dark">
      <Toolbar />
    </ThemeContext.Provider>
  );
}

function Toolbar() {
  const theme = useContext(ThemeContext);
  return <div className={`toolbar-${theme}`}>Current theme: {theme}</div>;
}
```

**Real-world use case:**
- Dark/light theme toggles across an entire app.
- Sharing logged-in user info (auth context) with any component.
- Language/locale settings for internationalization (i18n).

---

## Ref Hooks

### useRef

**Simple explanation:**
`useRef` gives you a box that holds a value which persists across renders, **without** causing a re-render when it changes. It's most commonly used to directly access a DOM element (like an input field), but it can also hold any mutable value (like a timer ID).

**Syntax:**
```jsx
const myRef = useRef(initialValue);
// access/update value with myRef.current
```

**Example:**
```jsx
import { useRef } from "react";

function TextInputFocus() {
  const inputRef = useRef(null);

  const focusInput = () => {
    inputRef.current.focus();
  };

  return (
    <div>
      <input ref={inputRef} type="text" />
      <button onClick={focusInput}>Focus the input</button>
    </div>
  );
}
```

**Real-world use case:**
- Auto-focusing an input field when a form opens.
- Storing a `setInterval`/`setTimeout` ID to clear it later.
- Keeping track of previous prop/state values without re-rendering.

---

### useImperativeHandle

**Simple explanation:**
Normally, a parent can't directly "command" a child component. `useImperativeHandle` (used with `forwardRef`) lets a child component expose a custom, limited set of functions or values to its parent — like giving the parent a specific remote control instead of full access.

**Syntax:**
```jsx
useImperativeHandle(ref, () => ({
  customMethod() { /* ... */ }
}));
```

**Example:**
```jsx
import { forwardRef, useRef, useImperativeHandle } from "react";

const FancyInput = forwardRef((props, ref) => {
  const inputRef = useRef();

  useImperativeHandle(ref, () => ({
    focus: () => {
      inputRef.current.focus();
    },
  }));

  return <input ref={inputRef} />;
});

function Parent() {
  const fancyInputRef = useRef();
  return (
    <div>
      <FancyInput ref={fancyInputRef} />
      <button onClick={() => fancyInputRef.current.focus()}>
        Focus Fancy Input
      </button>
    </div>
  );
}
```

**Real-world use case:**
- Building a reusable video player component that exposes `play()`/`pause()` methods.
- A custom modal component exposing `open()`/`close()` to its parent.
- Form libraries exposing a `validate()` or `reset()` method on custom inputs.

---

## Effect Hooks

### useEffect

**Simple explanation:**
`useEffect` lets a component "do something" after it renders — like fetching data, subscribing to something, or manually changing the DOM. Think of it as a to-do list that runs after React finishes painting the screen.

**Syntax:**
```jsx
useEffect(() => {
  // side effect code
  return () => {
    // optional cleanup
  };
}, [dependencies]);
```

**Example:**
```jsx
import { useState, useEffect } from "react";

function UserProfile({ userId }) {
  const [user, setUser] = useState(null);

  useEffect(() => {
    fetch(`https://api.example.com/users/${userId}`)
      .then((res) => res.json())
      .then((data) => setUser(data));
  }, [userId]); // runs again only when userId changes

  return <div>{user ? user.name : "Loading..."}</div>;
}
```

**Real-world use case:**
- Fetching data from an API when a component loads.
- Setting up a WebSocket connection and cleaning it up on unmount.
- Updating the page title (`document.title`) based on state.

---

### useLayoutEffect

**Simple explanation:**
It works almost exactly like `useEffect`, but it runs **synchronously right after the DOM updates, before the browser paints the screen**. Use it when you need to measure or change the DOM in a way that must happen before the user sees a flicker.

**Syntax:**
```jsx
useLayoutEffect(() => {
  // DOM measurement / mutation
}, [dependencies]);
```

**Example:**
```jsx
import { useLayoutEffect, useRef, useState } from "react";

function Tooltip() {
  const ref = useRef(null);
  const [height, setHeight] = useState(0);

  useLayoutEffect(() => {
    const rect = ref.current.getBoundingClientRect();
    setHeight(rect.height);
  }, []);

  return <div ref={ref}>Tooltip height: {height}px</div>;
}
```

**Real-world use case:**
- Measuring an element's size/position before rendering something dependent on it (like a tooltip or popover).
- Preventing visual flicker when adjusting scroll position.
- Synchronizing animations that must match the DOM state exactly.

---

### useInsertionEffect

**Simple explanation:**
This is a rare, specialized hook designed mainly for **CSS-in-JS libraries**. It fires even earlier than `useLayoutEffect` — before any DOM mutations from layout effects happen — so styles can be injected into the DOM without causing layout thrashing.

**Syntax:**
```jsx
useInsertionEffect(() => {
  // inject styles into the DOM
}, [dependencies]);
```

**Example:**
```jsx
import { useInsertionEffect } from "react";

function useCSS(rule) {
  useInsertionEffect(() => {
    const style = document.createElement("style");
    style.textContent = rule;
    document.head.appendChild(style);
    return () => document.head.removeChild(style);
  }, [rule]);
}

function StyledBox() {
  useCSS(".box { color: red; padding: 10px; }");
  return <div className="box">Styled with useInsertionEffect</div>;
}
```

**Real-world use case:**
- Used internally by libraries like styled-components or Emotion to inject dynamic styles.
- You'll rarely (if ever) use this directly in application code — it's a library-author tool.

---

## Performance Hooks

### useMemo

**Simple explanation:**
`useMemo` remembers ("memoizes") the **result** of an expensive calculation so React doesn't have to recompute it on every render — only when its dependencies change.

**Syntax:**
```jsx
const memoizedValue = useMemo(() => computeExpensiveValue(a, b), [a, b]);
```

**Example:**
```jsx
import { useMemo, useState } from "react";

function ExpensiveList({ items }) {
  const [filter, setFilter] = useState("");

  const filteredItems = useMemo(() => {
    console.log("Filtering...");
    return items.filter((item) => item.includes(filter));
  }, [items, filter]);

  return (
    <div>
      <input onChange={(e) => setFilter(e.target.value)} />
      <ul>
        {filteredItems.map((item) => (
          <li key={item}>{item}</li>
        ))}
      </ul>
    </div>
  );
}
```

**Real-world use case:**
- Filtering/sorting a large list only when the list or filter criteria change.
- Avoiding recalculating derived data (like totals, aggregates) on every keystroke.
- Preventing unnecessary re-renders of child components that receive computed props.

---

### useCallback

**Simple explanation:**
`useCallback` is like `useMemo`, but it memoizes a **function** instead of a value. This is useful because in JavaScript, functions are recreated on every render by default — which can cause unnecessary re-renders in child components that receive that function as a prop.

**Syntax:**
```jsx
const memoizedCallback = useCallback(() => {
  doSomething(a, b);
}, [a, b]);
```

**Example:**
```jsx
import { useCallback, useState } from "react";
import ChildButton from "./ChildButton";

function Parent() {
  const [count, setCount] = useState(0);

  const handleClick = useCallback(() => {
    console.log("Button clicked!");
  }, []); // never changes, so ChildButton won't needlessly re-render

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <ChildButton onClick={handleClick} />
    </div>
  );
}
```

**Real-world use case:**
- Passing stable event handlers to memoized child components (`React.memo`).
- Preventing unnecessary re-subscriptions in `useEffect` when a function is a dependency.
- Optimizing large lists where each row receives a callback prop.

---

### useTransition

**Simple explanation:**
`useTransition` lets you mark certain state updates as "non-urgent" (a transition), so React can keep the UI responsive (e.g., typing stays smooth) while a slower update (like filtering a huge list) happens in the background.

**Syntax:**
```jsx
const [isPending, startTransition] = useTransition();

startTransition(() => {
  // non-urgent state update
});
```

**Example:**
```jsx
import { useState, useTransition } from "react";

function SearchPage({ allItems }) {
  const [query, setQuery] = useState("");
  const [results, setResults] = useState(allItems);
  const [isPending, startTransition] = useTransition();

  const handleChange = (e) => {
    const value = e.target.value;
    setQuery(value); // urgent: update input immediately

    startTransition(() => {
      // non-urgent: filtering can lag slightly without blocking typing
      setResults(allItems.filter((item) => item.includes(value)));
    });
  };

  return (
    <div>
      <input value={query} onChange={handleChange} />
      {isPending && <p>Updating results...</p>}
      <ul>
        {results.map((item) => (
          <li key={item}>{item}</li>
        ))}
      </ul>
    </div>
  );
}
```

**Real-world use case:**
- Keeping a search box responsive while filtering thousands of results.
- Switching tabs in a dashboard without freezing the UI while heavy content loads.
- Any UI where typing/clicking must feel instant even though a bigger update follows.

---

### useDeferredValue

**Simple explanation:**
`useDeferredValue` lets a value "lag behind" the real state a little, so React can render urgent updates (like typing) first, and catch up the deferred value (like search results) once it's less busy. It's similar to `useTransition`, but for values you receive rather than updates you trigger.

**Syntax:**
```jsx
const deferredValue = useDeferredValue(value);
```

**Example:**
```jsx
import { useState, useDeferredValue, useMemo } from "react";

function SearchResults({ query, allItems }) {
  const deferredQuery = useDeferredValue(query);

  const results = useMemo(
    () => allItems.filter((item) => item.includes(deferredQuery)),
    [allItems, deferredQuery]
  );

  return (
    <ul>
      {results.map((item) => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  );
}

function App({ allItems }) {
  const [query, setQuery] = useState("");
  return (
    <div>
      <input value={query} onChange={(e) => setQuery(e.target.value)} />
      <SearchResults query={query} allItems={allItems} />
    </div>
  );
}
```

**Real-world use case:**
- Keeping an input field snappy while a large, filtered list "catches up" a moment later.
- Deferring heavy chart re-renders while a slider is being dragged.
- Any expensive UI section that shouldn't block a more important, fast-changing one.

---

## Other React Hooks

### useId

**Simple explanation:**
`useId` generates a unique, stable ID for a component instance — useful for accessibility attributes (like linking a label to an input) without risking ID collisions, especially in server-rendered apps.

**Syntax:**
```jsx
const id = useId();
```

**Example:**
```jsx
import { useId } from "react";

function LabeledInput() {
  const id = useId();
  return (
    <div>
      <label htmlFor={id}>Email:</label>
      <input id={id} type="email" />
    </div>
  );
}
```

**Real-world use case:**
- Generating unique `id`/`htmlFor` pairs for form labels and inputs.
- Linking ARIA attributes (`aria-describedby`, `aria-labelledby`) reliably.
- Avoiding duplicate IDs when the same component is rendered multiple times on a page.

---

### useSyncExternalStore

**Simple explanation:**
This hook lets React components safely read data from an "external store" — something that lives outside React's own state system (like a browser API, a third-party state library, or `localStorage`) — while keeping everything in sync, even during concurrent rendering.

**Syntax:**
```jsx
const state = useSyncExternalStore(subscribe, getSnapshot, getServerSnapshot?);
```

**Example:**
```jsx
import { useSyncExternalStore } from "react";

function subscribe(callback) {
  window.addEventListener("online", callback);
  window.addEventListener("offline", callback);
  return () => {
    window.removeEventListener("online", callback);
    window.removeEventListener("offline", callback);
  };
}

function getSnapshot() {
  return navigator.onLine;
}

function OnlineStatus() {
  const isOnline = useSyncExternalStore(subscribe, getSnapshot);
  return <p>You are {isOnline ? "online" : "offline"}</p>;
}
```

**Real-world use case:**
- Reading browser APIs like online/offline status or window size.
- Integrating third-party state management libraries (like Redux) safely with React 18+ concurrent features.
- Syncing UI with data stored outside React, such as a WebSocket connection state.

---

### useDebugValue

**Simple explanation:**
`useDebugValue` doesn't change how your app behaves at all — it just adds a helpful label to a **custom hook** so it's easier to identify in React DevTools while debugging.

**Syntax:**
```jsx
useDebugValue(value, formatFn?);
```

**Example:**
```jsx
import { useState, useDebugValue } from "react";

function useOnlineStatus() {
  const [isOnline, setIsOnline] = useState(true);

  useDebugValue(isOnline ? "Online" : "Offline");

  return isOnline;
}
```

**Real-world use case:**
- Labeling custom hooks (like `useAuth`, `useOnlineStatus`) so their state is readable in React DevTools.
- Helping teammates debug shared custom hooks in larger codebases.
- Not used in production logic — purely a developer-experience tool.

---

## React Router Hooks

> Note: These hooks are **not part of React itself** — they come from the `react-router-dom` package and only work inside components rendered within a `<BrowserRouter>` (or similar) context.

### useNavigate

**Simple explanation:**
`useNavigate` gives you a function to programmatically move the user to a different route/page — like clicking a link, but triggered from your own code (e.g., after a form submits).

**Syntax:**
```jsx
const navigate = useNavigate();
navigate("/path");
```

**Example:**
```jsx
import { useNavigate } from "react-router-dom";

function LoginForm() {
  const navigate = useNavigate();

  const handleLogin = () => {
    // ... login logic
    navigate("/dashboard");
  };

  return <button onClick={handleLogin}>Log In</button>;
}
```

**Real-world use case:**
- Redirecting users to a dashboard after successful login.
- Sending users back a page (`navigate(-1)`) with a "Cancel" or "Back" button.
- Redirecting unauthenticated users away from protected pages.

---

### useParams

**Simple explanation:**
`useParams` reads the dynamic parts of the current URL (like an ID) that were defined in your route path, so your component can know exactly which item to display.

**Syntax:**
```jsx
const { paramName } = useParams();
```

**Example:**
```jsx
// Route defined as: <Route path="/users/:userId" element={<UserProfile />} />
import { useParams } from "react-router-dom";

function UserProfile() {
  const { userId } = useParams();
  return <h1>Viewing profile for user #{userId}</h1>;
}
```

**Real-world use case:**
- Displaying a specific product page based on `/products/:productId`.
- Showing a specific blog post from `/blog/:slug`.
- Building user profile pages from `/users/:userId`.

---

### useLocation

**Simple explanation:**
`useLocation` gives you information about the current URL — like the pathname, search query string, and any extra state passed during navigation. It's like asking "where am I right now?"

**Syntax:**
```jsx
const location = useLocation();
// location.pathname, location.search, location.state, location.hash
```

**Example:**
```jsx
import { useLocation } from "react-router-dom";

function PageTracker() {
  const location = useLocation();

  console.log("Current path:", location.pathname);

  return <p>You are on: {location.pathname}</p>;
}
```

**Real-world use case:**
- Sending page-view analytics events whenever the route changes.
- Highlighting the active tab/link in a navigation bar.
- Reading extra data passed via `navigate("/path", { state: { from: "home" } })`.

---

### useSearchParams

**Simple explanation:**
`useSearchParams` lets you read and update the query string part of the URL (the part after `?`, like `?page=2&sort=asc`) as if it were state — perfect for filters, pagination, and search boxes that should be shareable via URL.

**Syntax:**
```jsx
const [searchParams, setSearchParams] = useSearchParams();
const value = searchParams.get("key");
setSearchParams({ key: "newValue" });
```

**Example:**
```jsx
import { useSearchParams } from "react-router-dom";

function ProductList() {
  const [searchParams, setSearchParams] = useSearchParams();
  const page = searchParams.get("page") || "1";

  return (
    <div>
      <p>Current page: {page}</p>
      <button onClick={() => setSearchParams({ page: Number(page) + 1 })}>
        Next Page
      </button>
    </div>
  );
}
```

**Real-world use case:**
- Pagination controls (`?page=2`) that survive a page refresh or shared link.
- Filter/sort options on an e-commerce listing page (`?category=shoes&sort=price`).
- Search pages where the query is stored in the URL (`?q=react+hooks`).

---

### useOutletContext

**Simple explanation:**
When using nested routes with a parent layout (`<Outlet />`), `useOutletContext` lets the parent pass data down to whichever child route is currently rendered inside the outlet — without prop drilling through the router itself.

**Syntax:**
```jsx
// In the parent layout:
<Outlet context={someValue} />

// In the child route:
const value = useOutletContext();
```

**Example:**
```jsx
import { Outlet, useOutletContext } from "react-router-dom";

function DashboardLayout() {
  const user = { name: "Alex", role: "Admin" };
  return (
    <div>
      <h1>Dashboard</h1>
      <Outlet context={user} />
    </div>
  );
}

function Settings() {
  const user = useOutletContext();
  return <p>Settings for {user.name} ({user.role})</p>;
}
```

**Real-world use case:**
- Sharing the logged-in user object with every nested page inside a dashboard layout.
- Passing shared layout data (like a selected workspace/team) to nested child routes.
- Avoiding re-fetching the same data in every nested route.

---

## Quick Reference Table

| Hook | Category | One-line purpose |
|---|---|---|
| `useState` | State | Store and update simple component state |
| `useReducer` | State | Manage complex state via actions/reducer |
| `useContext` | Context | Read shared data without prop drilling |
| `useRef` | Ref | Persist a mutable value / access DOM nodes |
| `useImperativeHandle` | Ref | Expose custom methods to parent via ref |
| `useEffect` | Effect | Run side effects after render |
| `useLayoutEffect` | Effect | Run side effects synchronously before paint |
| `useInsertionEffect` | Effect | Inject styles before layout effects (CSS-in-JS) |
| `useMemo` | Performance | Memoize an expensive computed value |
| `useCallback` | Performance | Memoize a function reference |
| `useTransition` | Performance | Mark state updates as low priority |
| `useDeferredValue` | Performance | Defer a value's update to stay responsive |
| `useId` | Other | Generate unique, stable IDs |
| `useSyncExternalStore` | Other | Subscribe safely to external data stores |
| `useDebugValue` | Other | Label custom hooks in DevTools |
| `useNavigate` | Router | Programmatically change routes |
| `useParams` | Router | Read dynamic URL segments |
| `useLocation` | Router | Read current URL info |
| `useSearchParams` | Router | Read/update the URL query string |
| `useOutletContext` | Router | Pass data to nested routes |
