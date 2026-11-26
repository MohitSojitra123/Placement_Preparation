# 50 High-Yield String Interview Questions (Basic to Hard)
This document provides 50 standard and advanced coding interview string questions designed to improve logic formulation, complete with scenarios, problem statements, and sample input/output.


## 🟢 Basic Level

### 1. Reverse Words in a String
- **Real-World Scenario:** Cleaning up user-submitted text fields or formatting logs.
- **Problem:** Given an input string s, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space.
- **Input:** `s = "  the sky is blue  "`
- **Output:** `"blue is sky the"`

### 2. Valid Palindrome (Ignoring Case & Alphanumeric)
- **Real-World Scenario:** Processing search queries or usernames where case and special characters shouldn't disrupt matching.
- **Problem:** A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
- **Input:** `s = "A man, a plan, a canal: Panama"`
- **Output:** `true`

### 3. First Unique Character in a String
- **Real-World Scenario:** Stream processing, identifying the first unique transaction ID, or optimization in caching.
- **Problem:** Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
- **Input:** `s = "loveleetcode"`
- **Output:** `2`

### 4. Valid Anagram
- **Real-World Scenario:** Verifying if two digital signatures contain the exact same components or validating security tokens that have been rearranged.
- **Problem:** Given two strings s and t, return true if t is an anagram of s, and false otherwise. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
- **Input:** `s = "anagram", t = "nagaram"`
- **Output:** `true`

### 5. Longest Common Prefix
- **Real-World Scenario:** Autocomplete features or parsing URL paths/directories to find a shared base domain or root folder.
- **Problem:** Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
- **Input:** `strs = ["flower","flow","flight"]`
- **Output:** `"fl"`

### 6. Isomorphic Strings
- **Real-World Scenario:** Mapping old structural database IDs to a new schema pattern, or basic monoalphabetic substitution ciphers.
- **Problem:** Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t. All occurrences of a character must be replaced with another character while preserving the order of characters.
- **Input:** `s = "egg", t = "add"`
- **Output:** `true`

### 7. Length of Last Word
- **Real-World Scenario:** Parsing formatted textual reports where the final field contains a trailing status word.
- **Problem:** Given a string s consisting of words and spaces, return the length of the last word in the string.
- **Input:** `s = "   fly me   to   the moon  "`
- **Output:** `4`

### 8. Reverse String
- **Real-World Scenario:** In-place data structures inversion, fundamental low-level memory manipulation.
- **Problem:** Write a function that reverses a string. The input string is given as an array of characters s. You must do this by modifying the input array in-place with O(1) extra memory.
- **Input:** `s = ["h","e","l","l","o"]`
- **Output:** `["o","l","l","e","h"]`

### 9. FizzBuzz String Generation
- **Real-World Scenario:** Basic conditional formatting patterns for analytical dashboard metrics.
- **Problem:** Given an integer n, return a string array answer (1-indexed) where answer[i] is 'FizzBuzz' if divisible by 3 and 5, 'Fizz' if divisible by 3, 'Buzz' if divisible by 5, or the number as a string otherwise.
- **Input:** `n = 3`
- **Output:** `["1","2","Fizz"]`

### 10. Detect Capital
- **Real-World Scenario:** Enforcing grammatical validation rules in text editors or document processing systems.
- **Problem:** We define the usage of capitals in a word to be right when all letters are capitals, all letters are lowercase, or only the first letter is capital. Given a string word, return true if the usage of capitals in it is right.
- **Input:** `word = "USA"`
- **Output:** `true`

### 11. Valid Palindrome II
- **Real-World Scenario:** Fuzzy matching in search query corrections, tolerating a single typo.
- **Problem:** Given a string s, return true if the s can be palindrome after deleting at most one character from it.
- **Input:** `s = "aba"`
- **Output:** `true`

### 12. Find the Index of the First Occurrence in a String
- **Real-World Scenario:** Implementing basic sub-string search operations like standard indexOf() or strstr() functions.
- **Problem:** Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
- **Input:** `haystack = "sadbutsad", needle = "sad"`
- **Output:** `0`

### 13. Jewels and Stones
- **Real-World Scenario:** Inventory reconciliation or counting specific prioritized security tokens inside a stream.
- **Problem:** You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
- **Input:** `jewels = "aA", stones = "aAAbbbb"`
- **Output:** `3`

### 14. To Lower Case
- **Real-World Scenario:** Normalizing text formats before database inserts or comparison checks.
- **Problem:** Given a string s, return the string after replacing every uppercase letter with the same lowercase letter without using built-in library methods.
- **Input:** `s = "Hello"`
- **Output:** `"hello"`

### 15. Merge Strings Alternately
- **Real-World Scenario:** Interleaving two parallel data message streams or merging historical log records alternately.
- **Problem:** You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer, append the additional letters onto the end of the merged string.
- **Input:** `word1 = "abc", word2 = "pqr"`
- **Output:** `"apbqcr"`


## 🟡 Intermediate Level

### 16. Longest Substring Without Repeating Characters
- **Real-World Scenario:** Tracking unique user sessions, telemetry data windows, or data streaming analytics.
- **Problem:** Given a string s, find the length of the longest substring without repeating characters.
- **Input:** `s = "abcabcbb"`
- **Output:** `3`

### 17. String to Integer (atoi)
- **Real-World Scenario:** Implementing standard library functions or parsing raw configuration/log files where data types aren't predefined.
- **Problem:** Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer. Handle leading whitespace, sign characters, and overflow bounds.
- **Input:** `s = "   -42 with words"`
- **Output:** `-42`

### 18. Group Anagrams
- **Real-World Scenario:** Categorizing inventory with mismatched naming, cryptography, or grouping profile IDs that share exact character pools.
- **Problem:** Given an array of strings strs, group the anagrams together. You can return the answer in any order.
- **Input:** `strs = ["eat","tea","tan","ate","nat","bat"]`
- **Output:** `[["bat"],["nat","tan"],["ate","eat","tea"]]`

### 19. Longest Palindromic Substring
- **Real-World Scenario:** DNA sequence analysis matching symmetrical gene markers, or processing data packets to find reflecting transmission errors.
- **Problem:** Given a string s, return the longest palindromic substring in s.
- **Input:** `s = "babad"`
- **Output:** `"bab"`

### 20. String Compression
- **Real-World Scenario:** Implementing a basic Run-Length Encoding (RLE) lossy-free compression algorithm for resource-constrained network transfers.
- **Problem:** Given an array of characters chars, compress it in-place using Run-Length Encoding. For groups of consecutive repeating characters, append character followed by count if count > 1.
- **Input:** `chars = ["a","a","b","b","c","c","c"]`
- **Output:** `6 (Array becomes: ["a","2","b","2","c","3"])`

### 21. Find All Anagrams in a String
- **Real-World Scenario:** Text pattern matching engines where the order of keywords in a paragraph doesn't matter, but their proximity does.
- **Problem:** Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
- **Input:** `s = "cbaebabacd", p = "abc"`
- **Output:** `[0, 6]`

### 22. Repeated DNA Sequences
- **Real-World Scenario:** Biomedical software mapping repeating 10-letter-long sequences in genetic code to isolate genomic variations.
- **Problem:** Given a string s that represents a DNA sequence, return all the 10-letter-long substrings that occur more than once in a DNA molecule.
- **Input:** `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`
- **Output:** `["AAAAACCCCC", "CCCCCAAAAA"]`

### 23. Multiply Strings
- **Real-World Scenario:** Arbitrary-precision arithmetic (BigInt) calculators handling large monetary/cryptographic numbers that exceed native 64-bit bounds.
- **Problem:** Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string without using any built-in BigInteger libraries.
- **Input:** `num1 = "123", num2 = "456"`
- **Output:** `"56088"`

### 24. Longest Substring with At Most K Distinct Characters
- **Real-World Scenario:** Configuring content streaming buffers or tracking dynamic unique active product IDs.
- **Problem:** Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
- **Input:** `s = "eceba", k = 2`
- **Output:** `3 ("ece")`

### 25. Zigzag Conversion
- **Real-World Scenario:** Custom text encryption techniques or formatting specialized display banners.
- **Problem:** The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows. Read it line by line to return the combined string.
- **Input:** `s = "PAYPALISHIRING", numRows = 3`
- **Output:** `"PAHNAPLSIIGYIR"`

### 26. Generate Parentheses
- **Real-World Scenario:** Compiler logic generators or code auto-completers outputting structurally safe nested syntax structures.
- **Problem:** Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
- **Input:** `n = 3`
- **Output:** `["((()))","(()())","(())()","()(())","()()()"]`

### 27. Decode String
- **Real-World Scenario:** Parsing compressed nested protocols or deserializing layout/render instructions (e.g., HTML structure shortcodes).
- **Problem:** Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
- **Input:** `s = "3[a]2[bc]"`
- **Output:** `"aaabcbc"`

### 28. Palindromic Substrings (Count)
- **Real-World Scenario:** Acoustic reflection pattern counts or structural integrity validation metrics.
- **Problem:** Given a string s, return the number of palindromic substrings in it. Substrings with different start or end indices are counted as unique.
- **Input:** `s = "abc"`
- **Output:** `3 ("a", "b", "c")`

### 29. Minimum Remove to Make Valid Parentheses
- **Real-World Scenario:** SQL compiler syntax cleaner correcting unclosed brackets or formatting math expression text editors.
- **Problem:** Given a string s of '(' , ')' and lowercase English characters. Remove the minimum number of parentheses so that the resulting parentheses string is valid and return any valid string.
- **Input:** `s = "lee(t(c)o)de)"`
- **Output:** `"lee(t(c)o)de"`

### 30. Custom Sort String
- **Real-World Scenario:** Implementing custom locale ordering or sorting catalog items by a non-alphabetical business priority order.
- **Problem:** You are given two strings order and s. All the characters of order are unique and were sorted in some custom order. Permute the characters of s so that they match the order that order was sorted.
- **Input:** `order = "cba", s = "abcd"`
- **Output:** `"cbad"`

### 31. Compare Version Numbers
- **Real-World Scenario:** Package managers (npm, pip) or deployment pipelines determining if a software upgrade or rollback is required.
- **Problem:** Given two version strings, version1 and version2, compare them. If version1 > version2 return 1; if version1 < version2 return -1; otherwise return 0.
- **Input:** `version1 = "1.01", version2 = "1.001"`
- **Output:** `0`

### 32. Reverse Words in a String III
- **Real-World Scenario:** Preparing text blocks for specific reading tracking interfaces or formatting message previews.
- **Problem:** Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
- **Input:** `s = "Let's take LeetCode contest"`
- **Output:** `"s'teL ekat edoCteeL tsetnoc"`

### 33. Basic Calculator II
- **Real-World Scenario:** Building a core expression evaluator engine for configuration files or spreadsheet cell calculations.
- **Problem:** Given a string s which represents an expression, evaluate this expression. String contains non-negative integers, '+', '-', '*', '/' operators and empty spaces.
- **Input:** `s = "3+2*2"`
- **Output:** `7`

### 34. Valid Parenthesis String (with Asterisks)
- **Real-World Scenario:** Advanced parser logic where standard symbols can double as wildcards or optional markers.
- **Problem:** Given a string s containing only '(', ')' and '*', return true if s is valid, where '*' can be treated as a single '(', a single ')', or an empty string.
- **Input:** `s = "(*)"`
- **Output:** `true`

### 35. Optimal Partition of String
- **Real-World Scenario:** Breaking a long contiguous stream of sensor values into minimum distinct sub-logs for transactional storage.
- **Problem:** Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. Return the minimum number of substrings in such a partition.
- **Input:** `s = "abacaba"`
- **Output:** `4 (["ab", "ac", "ab", "a"])`


## 🔴 Hard Level

### 36. Minimum Window Substring
- **Real-World Scenario:** Bio-informatics (finding gene sequences) or matching a set of required keywords in a document with the shortest text snippet.
- **Problem:** Given two strings s and t, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
- **Input:** `s = "ADOBECODEBANC", t = "ABC"`
- **Output:** `"BANC"`

### 37. Regular Expression Matching
- **Real-World Scenario:** Compilers, custom text validation engines, or routing engines that accept wildcards.
- **Problem:** Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where '.' matches any single character and '*' matches zero or more of the preceding element.
- **Input:** `s = "aa", p = "a*"`
- **Output:** `true`

### 38. Edit Distance (Levenshtein Distance)
- **Real-World Scenario:** Spell checkers, 'Did you mean?' search suggestions, or calculating genetic mutation distances.
- **Problem:** Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2 (Insert, Delete, or Replace).
- **Input:** `word1 = "horse", word2 = "ros"`
- **Output:** `3`

### 39. Longest Valid Parentheses
- **Real-World Scenario:** Compiler parsing engines validating nested code blocks or JSON structure integrity checks.
- **Problem:** Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
- **Input:** `s = ")()())"`
- **Output:** `4`

### 40. Distinct Subsequences
- **Real-World Scenario:** Tracking user journey paths or structural state transition alignments where historical sub-patterns are counted.
- **Problem:** Given two strings s and t, return the number of distinct subsequences of s which equals t.
- **Input:** `s = "rabbbit", t = "rabbit"`
- **Output:** `3`

### 41. Shortest Palindrome
- **Real-World Scenario:** Data alignment algorithms or optimization of redundant communication stream packaging.
- **Problem:** You are given a string s. You can convert s to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
- **Input:** `s = "aacecaaa"`
- **Output:** `"aaacecaaa"`

### 42. Wildcard Matching
- **Real-World Scenario:** File pattern matching implementations (like glob/shell expansion rules) or route managers.
- **Problem:** Given an input string s and a pattern p, implement wildcard pattern matching with support for '?' (matches any single character) and '*' (matches any sequence of characters).
- **Input:** `s = "aa", p = "*"`
- **Output:** `true`

### 43. Text Justification
- **Real-World Scenario:** Building text layout engines for PDF creation tools, e-readers, or terminal printers.
- **Problem:** Given an array of strings words and a width maxWidth, format the text so that each line has exactly maxWidth characters and is fully (left and right) justified.
- **Input:** `words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16`
- **Output:** `["This    is    an", "example  of text", "justification.  "]`

### 44. Substring with Concatenation of All Words
- **Real-World Scenario:** Searching for composite multi-token patterns in logs or fixed-length continuous data protocols.
- **Problem:** Given a string s and an array of strings words of the same length, return the starting indices of all concatenated substrings in s that contain each word exactly once without any intervening characters.
- **Input:** `s = "barfoothefoobarman", words = ["foo","bar"]`
- **Output:** `[0,9]`

### 45. Word Ladder
- **Real-World Scenario:** Mapping step-by-step conversion paths in multi-state network systems or computational linguistics.
- **Problem:** Given two words (beginWord and endWord) and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, changing only one letter at a time.
- **Input:** `beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]`
- **Output:** `5`

### 46. Scramble String
- **Real-World Scenario:** Advanced structural permutation checking and multi-layered algorithmic partitioning verification.
- **Problem:** Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1 using binary tree structural swapping representation.
- **Input:** `s1 = "great", s2 = "rgeat"`
- **Output:** `true`

### 47. Minimum Window Subsequence
- **Real-World Scenario:** Sequential log auditing where exact sequence chronological order must be preserved over the shortest elapsed span.
- **Problem:** Given strings s1 and s2, find the minimum contiguous substring of s1 such that s2 is a subsequence of the substring. If no such window exists, return empty string.
- **Input:** `s1 = "abcdebdde", s2 = "bde"`
- **Output:** `"bcde"`

### 48. Palindrome Pairs
- **Real-World Scenario:** Indexing systems searching for valid string pairs that can be concatenated into single palindromic terms.
- **Problem:** Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] forms a palindrome.
- **Input:** `words = ["abcd","dcba","lls","s","sssll"]`
- **Output:** `[[0,1],[1,0],[3,2],[2,4]]`

### 49. Orderly Queue
- **Real-World Scenario:** Lexicographical buffer stream re-ordering optimization under strict transactional shift constraints.
- **Problem:** Given a string s and an integer k. You can choose one of the first k letters of s and append it to the end of the string. Return the lexicographically smallest string you could have after any number of moves.
- **Input:** `s = "cba", k = 1`
- **Output:** `"acb"`

### 50. Count Unique Characters of All Substrings of a Given String
- **Real-World Scenario:** Advanced data metric indexing calculating historical unique sequence frequency sums across telemetry blocks.
- **Problem:** Let's define a function countUniqueChars(s) that returns the number of unique characters on s. Given a string s, return the sum of countUniqueChars(t) where t is all substrings of s.
- **Input:** `s = "ABC"`
- **Output:** `10`

