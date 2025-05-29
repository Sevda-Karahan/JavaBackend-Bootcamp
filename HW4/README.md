# 📚 Library Book Tracking System

A simple Java console application to manage a library’s book inventory, including adding, removing, and updating stock. All operations are persisted via file I/O and recorded in a log file for traceability.

---

## 📌 Description

This application tracks book check-ins and check-outs in a small library setting. It supports:

- Persistent storage of books in a file
- Real-time updates to inventory
- Logging of user actions and exceptions
- Custom exception handling

---

## 📁 File Handling (`File` Class)

- A file named `kitaplar.txt` stores book data.
- Each book record is stored in the following format:


**Example:**
```plaintext
Book Title,Author,Stock Quantity 
Simyacı,Paulo Coelho,5
Suç ve Ceza,Fyodor Dostoyevski,2
```


- On startup:
- If the file exists, its contents are loaded into memory.
- If not, a new file is created automatically.

---

## ✍️ Read & Write Operations (`BufferedReader` / `BufferedWriter`)

- The user can:
- ➕ Add a book
- ❌ Delete a book
- 🔄 Update stock of a book

- All changes are instantly written to `kitaplar.txt`.

- A log file named `log.txt` is maintained:
- Logs every operation (timestamp + action)
- Logs all exceptions and error messages

---

## ⚠️ Exception Handling

- All file-related and input-related errors are handled using `try-catch` blocks.
- When an exception occurs:
- The user is informed with a clear message.
- The error is written to `log.txt` with a timestamp.

---

## ❗ Custom Exception Class: `InvalidStockException`

- A custom exception named `InvalidStockException` is defined.
- If an operation results in a negative stock value, this exception is thrown.
- The system:
- Prevents the operation
- Shows a warning to the user
- Logs the incident in `log.txt`

---

✅ Sample Output

![image](https://github.com/user-attachments/assets/568a9a7a-3fab-4749-b315-f2fc640969db)

![image](https://github.com/user-attachments/assets/852c05cf-26dd-4fbf-8f3d-da094fb5b568)

![image](https://github.com/user-attachments/assets/e60dd41b-2573-4408-868c-6a51360c2f2d)

![image](https://github.com/user-attachments/assets/a76975d1-2a0b-4ee6-99de-83a2bea9099a)
