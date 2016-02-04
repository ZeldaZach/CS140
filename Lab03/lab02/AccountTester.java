package lab02;

import java.util.Random;

public class AccountTester
{
	public static void main(String[] args)
	{
		Account[] myAccounts = new Account[10];
		System.out.println("Starting balances:");
		for (int i = 0; i < myAccounts.length; i++)
		{
			int val = randInt(30, 10000);
			myAccounts[i] = new Account(val);
			System.out.println(myAccounts[i].money); // Print all account values
		}

		System.out.println();
		
		System.out.println("Max accounts (each loop):");
		System.out.println(mostMoneyAccount_for(myAccounts).money);
		System.out.println(mostMoneyAccount_foreach(myAccounts).money);
		
		System.out.println();
		
		int addToAll = randInt(1, 4350);
		containTheWard(myAccounts, addToAll);
		
		System.out.println("Money to add to all: " + addToAll);
		for (Account key : myAccounts)
		{
			System.out.println(key.money);
		}
		
		System.out.println();
		
		System.out.println("Max accounts (each loop after deposit):");
		System.out.println(mostMoneyAccount_for(myAccounts).money);
		System.out.println(mostMoneyAccount_foreach(myAccounts).money);
	}
	
	public static int randInt(int min, int max)
	{
		// Taken from StackOverflow
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static Account mostMoneyAccount_foreach(Account[] array)
	{
		if (array != null)
		{
			Account maxAcc = array[0];
			int maxMoney = maxAcc.money;
		
			for (Account key : array)
			{
				if (key.money > maxMoney)
				{
					maxAcc = key;
					maxMoney = key.money;
				}
			}
		
			return maxAcc;
		}
		return new Account(0);
	}
	
	public static Account mostMoneyAccount_for(Account[] array)
	{
		if (array != null)
		{
			Account maxAcc = array[0];
			int maxMoney = maxAcc.money;
		
			for (int i = 1; i < array.length; i++)
			{
				if (array[i].money > maxMoney)
				{
					maxAcc = array[i];
					maxMoney = array[i].money;
				}
			}
		
			return maxAcc;
		}
		return new Account(0);
	}
	
	public static void containTheWard(Account[] array, int amount)
	{
		for (Account key : array)
		{
			key.deposit(amount);
		}
	}
}