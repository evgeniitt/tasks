package ru.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    static float cx;
    static float cy;
    static int r;

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader circleReader = new BufferedReader(new FileReader(args[0]));
        BufferedReader pointReader = new BufferedReader(new FileReader(args[1]));
        List<String> points = pointReader.lines().collect(Collectors.toList());
        List<String> circleData = circleReader.lines().collect(Collectors.toList());
        String[] point = circleData.get(0).split(" ");
        cx = Float.parseFloat(point[0]);
        cy = Float.parseFloat(point[1]);
        r = Integer.parseInt(circleData.get(1));
        for (String p : points) {
            String[] pxy = p.split(" ");
            float px = Float.parseFloat(pxy[0]);
            float py = Float.parseFloat(pxy[1]);
            findPoint(px, py);
        }
    }


    private static void findPoint(float x, float y) {
        double l = Math.sqrt(Math.pow(Math.abs(x - cx), 2) + Math.pow(Math.abs(y - cy), 2));
        if(l > r){
            System.out.println("точка находится вне окружности");
        }else{
            System.out.println("точка находится в окружности");
        }
    }
}
