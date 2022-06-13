package com.Paypl.classes;

import com.Paypl.Player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
    public ArrayList<GameObject> gameObjects = new ArrayList<>();

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void addGameObjects(GameObject gameObject) {gameObjects.add(gameObject);}



}
