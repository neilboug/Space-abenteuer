# 🚀 Space-Abenteuer

**Space-Abenteuer** is a 2D Java **platform game** developed as the final project for a **first-year university module** in *Programming in Java*. The game challenges players to control a space rover, collect redstone, and progress through a series of levels with increasing difficulty.

---

## 🎮 Gameplay Overview

In **Space-Abenteuer**, you operate a rover exploring alien landscapes. Navigate through obstacles, collect redstone, and complete levels. The game features jump mechanics and enemy-free platforming across multiple stages.

### 🧩 Game Objectives
- Collect all **redstone** to finish each level
- Navigate terrain using platform mechanics (jump, fall, move)
- Progress through **five custom levels**
- Use GUI controls to **save**, **load**, and **reset** the game state

---

## 🎓 Academic Context

This game was created as part of the **first-year Java programming module** at university. It applies foundational programming principles in a creative, engaging way — combining OOP with GUI and interactive gameplay logic.

---

## 🧰 Tech Stack

- **Language**: Java
- **IDE**: IntelliJ IDEA
- **GUI**: Java Swing / AWT
- **Persistence**: File I/O system with `GameSaverLoader`

---

## 📁 Project Structure

```text
src/
├── Game.java               # Game launcher
├── GameView.java           # Game window and graphics
├── ControlPanel.java       # GUI control buttons
├── GameSaverLoader.java    # Save/load game state
│ ...
├── GameLevel.java          # Abstract base class for all levels
├── Level1.java - Level5.java # Individual platforming levels
│ ...
├── Rover.java              # Player-controlled character
├── RoverControls.java      # Handles input and movement
└── RedstoneCollection.java # Logic for collectible redstone
```

---

## ▶️ How to Run

### 1. Clone the Project
```bash
git clone https://github.com/neilboug/Space-abenteuer.git
cd Space-abenteuer
```

### 2. Open in IDE
- Open the Space-abenteuer folder as a project
- Open Game.java
- Click ▶️ to run

---

🕹️ Controls

- Arrow Keys / WASD – Move the rover
- Control Panel:
  - Reset – Restart level
  - Save – Save progress
  - Load – Resume progress
  - Quit – Exit game

---

🧠 Features

- 🔁 Level transitions and object-oriented inheritance via GameLevel
- 🛠️ Built-in state persistence system (GameSaverLoader)
- 🖱️ Responsive GUI layout with separate game panel and control panel
- 🧩 Platformer mechanics using Java physics and collision handling

---

## 📺 Gameplay Demo

Here’s a short GIF demo of Space-Abenteuer in action:

<p align="center">
  <img src="https://github.com/neilboug/Space-abenteuer/blob/main/demo/demo.gif" width="350" alt="Gameplay Demo">
</p>
