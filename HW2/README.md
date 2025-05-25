# E-Commerce Order and Shipping Management System

## 📦 Project Overview

This is a basic Java-based e-commerce and shipping management system. It simulates an online shopping scenario where customers can order different types of products (like books, clothing, electronics), apply discounts, and track their shipping status.

---

## 🧠 OOP Concepts Applied

The project is designed to implement essential Object-Oriented Programming (OOP) concepts:

- **Classes and Objects** – Each real-world entity like Product, Customer, Order, etc., is represented as a class.
- **Constructors and Methods** – Constructors initialize objects; methods define behaviors (e.g., applyDiscount, ship).
- **Inheritance** – Common properties of all products are defined in an abstract superclass (`Product`), and specific product types inherit from it (`Book`, `Clothing`, `Electronics`).
- **Polymorphism** – The system uses polymorphic behavior through overridden methods such as `getDescription()` in each product type.
- **Abstract Classes and Interfaces** – `Product` is an abstract class. The `Shippable` interface defines the contract for shipping functionality, implemented by products.

---

## 🧱 Project Structure

```plaintext
src/
├── Main.java
├── Product.java           // Abstract class
├── Book.java              // Inherits from Product
├── Clothing.java          // Inherits from Product
├── Electronics.java       // Inherits from Product
├── Shippable.java         // Interface
├── Customer.java
├── Order.java
└── ShippingStatus.java    // Enum: PREPARING → SHIPPED → DELIVERED
```

---

✅ Features
- Support for different product types: Book, Clothing, Electronics

- Each product has shared attributes (name, price) and custom details (e.g., author for Book, size for Clothing)

- Products implement the Shippable interface, enabling shipment with address

- Customers can place multiple orders and manage them

- Orders contain multiple products

- Discount functionality is available for all products

- Shipping status can be updated dynamically: PREPARING → SHIPPED → DELIVERED
