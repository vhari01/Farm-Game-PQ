# 🐄 Farm Management Simulator – Java OOP Project

This project was a farm simulation game built using **Object-Oriented Programming in Java**, where players managed a virtual farm by feeding animals, expanding land, and handling limited resources. It simulated the logic of a farm management game using a combination of class hierarchies, data structures, and interactive gameplay.

## 🌾 Project Summary

The game featured different animals like **Llama**, **Cow**, and **Chicken**, all inheriting from a common `Animal` superclass. Each animal had attributes such as **hunger**, **food requirement**, and **production potential**. The player’s role was to manage these animals by feeding them based on hunger priority, with limited food supplies available at each stage.

## 🧩 Key Features

- 🐮 **Animal Inheritance Structure**: All animals extended from a base `Animal` class using OOP principles.
- 🍽 **Hunger-Based Priority Queue**: Animals were added to a priority queue based on hunger level, ensuring the hungriest ones were fed first.
- 🌽 **Limited Resources**: Players had to manage a restricted supply of feed, forcing them to make strategic decisions.
- 🏡 **Farm Expansion**: As the game progressed, the farm could grow by acquiring more animals and increasing land capacity.
- 🎮 **Game Logic**: If animals remained hungry for too long, they could stop producing resources or leave the farm, adding to the challenge.

## 🛠 Technologies Used

- **Java (OOP)**: Core game design, class inheritance, and farm logic
- **Priority Queue**: Used to manage animal hunger in real time
- **Java Collections**: For managing animals, feed, and resources
