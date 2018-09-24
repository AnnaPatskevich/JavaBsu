package com.company;


import java.util.Scanner;
import java.util.Random;

        public class Main
        {
            public static void main(String[] args)
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Введите n: ");

                if(in.hasNextInt() == false)
                {
                    System.out.println("Некорректный ввод, вы ввели не число!");
                    System.exit(1);
                }

                int n = in.nextInt();

                if( n<=1 )
                {
                    System.out.println("Размерность некорректна(нужно: n > 1).");
                    System.exit(1);
                }

                int mass[][]=new int[n][n];
                int tempMass[] = new int[n];//в нем будет храниться сумма каждой строчки массива mass
                Random rnd = new Random();

                System.out.println("Исходная матрица:");
                for(int i = 0; i < n; i++)
                {
                    int summa = 0;
                    for(int j = 0; j < n; j++)
                    {
                        int temp = rnd.nextInt();
                        mass[i][j] = temp % (n + 1);
                        summa += mass[i][j];
                        System.out.print(mass[i][j] + " ");
                    }
                    tempMass[i] = summa;
                    System.out.println();
                }
                System.out.println();

		/*
		System.out.println("Исходный tempMass:");
		for(int i = 0; i < n; i++) {
			System.out.print(tempMass[i] + " ");
		}
		System.out.println();
		*/

                for (int i=n-1; i>=0; i--)
                {
                    for (int j=0; j<i; j++)
                    {
                        if (tempMass[j] > tempMass[j+1])
                        {
                            for(int k=0; k<n; k++)
                            {
                                int tmp = mass[j][k];
                                mass[j][k] = mass[j+1][k];
                                mass[j+1][k] = tmp;
                            }
                            int tmp = tempMass[j];
                            tempMass[j] = tempMass[j+1];
                            tempMass[j+1] = tmp;
                        }
                    }
                }

		/*
		System.out.println("Отсортированный tempMass:");
		for(int i = 0; i < n; i++) {
			System.out.print(tempMass[i] + " ");
		}
		System.out.println();
		*/

                System.out.println("Отсортированный mass(по возрастанию сумм элементов в каждой строчке):");
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++)
                        System.out.print(mass[i][j] + " ");
                    System.out.println();
                }
                System.out.println();


                in.close();
            }

        }
