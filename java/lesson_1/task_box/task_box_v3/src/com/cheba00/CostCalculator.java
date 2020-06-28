package com.cheba00;

public class CostCalculator{
	private double kgCost;
	private double kmCost;
	
	public CostCalculator(double kgCost, double kmCost){
		 this.kmCost = kmCost;
		 this.kgCost = kgCost;
	}; 
	public double calcCost(Box box, int km){
		return box.getWeight() * kgCost + km * kmCost;  
	};
};
