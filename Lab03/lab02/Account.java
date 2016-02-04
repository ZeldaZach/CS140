package lab02;

public class Account
{
	public int money;
	
	public Account(int money)
	{
		this.money = money;
	}
	
	public void deposit(int toDeposit)
	{
		money += toDeposit;
	}
}