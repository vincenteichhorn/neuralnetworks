package de.vincenteichhorn.main;

import java.util.Locale;
import java.util.Scanner;

import de.vincenteichhorn.math.Util;
import de.vincenteichhorn.nnml.NeuralNetwork;

public class Main {

	static NeuralNetwork nn;
	static double[][] train = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static double[][] target = { { 0 }, { 1 }, { 1 }, { 0 } };

	public static void main(String[] args) throws Exception {
		int[] hidden = { 10 };
		nn = new NeuralNetwork(2, hidden, 1, 0.1);

		for(int i = 0; i < 1000; i++) {
			System.out.println("step");
			for(int j = 0; j < 4; j++) {
				nn.train(train[j], target[j]);
			}
		}

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input 1: ");
			double[] in = {sc.nextDouble(), -1};
			System.out.println("Input 2: ");
			in[1] = sc.nextDouble();
			System.out.println("Output:" + round(nn.getGuess(in)[0], 0));
		}
	}

	static double round(double val, int digits) {
		return Math.round(val * Math.pow(10, digits)) / Math.pow(10, digits);
	}

}
