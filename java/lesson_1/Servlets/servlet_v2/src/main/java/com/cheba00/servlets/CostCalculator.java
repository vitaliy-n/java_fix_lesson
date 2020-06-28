package com.cheba00.servlets;

public class CostCalculator{
	private double kgCost;
	private double kmCost;

	public CostCalculator(double kgCost, double kmCost){
		 this.kmCost = kmCost;
		 this.kgCost = kgCost;
	};
	public double calcCost(double kg, double km){
		return kg * kgCost + km * kmCost;
	};
};
