/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a7main;

/**
 *
 * @author staleyh
 */
public class SavingsAccount {
    private double annualInterestRate, balance, accumulativeInterest, accumulativeDeposits = 0, accumulativeWithdrawals = 0;

	// Constructor
	public SavingsAccount(double Bal)
	{
		balance = Bal;
	}

	// Calculators
	public void withdraw(double Witd)
	{
		balance -= Witd;
		accumulativeWithdrawals += Witd;
	}

	public void deposit(double Dep)
	{
		balance += Dep;
		accumulativeDeposits += Dep;
	}

	public void addMonthlyInterest()
	{
		accumulativeInterest += balance * (annualInterestRate/12);
		balance += balance * (annualInterestRate/12);
	}

	// Set Functions
	public void setBalance(double Bal)
	{
		balance = Bal;
	}

	public void setAnnualInterestRate(double AnnIntRte)
	{
		annualInterestRate = AnnIntRte;
	}

	// Get Functions
	public double getBalance()
	{
		return balance;
	}

	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}

	public double getMonthlyInterest()
	{
		return balance * (annualInterestRate/12);
	}

	public double getAccumulativeInterest()
	{
		return accumulativeInterest;
	}

	public double getAccumulativeDeposits()
	{
		return accumulativeDeposits;
	}

	public double getAccumulativeWithdrawals()
	{
		return accumulativeWithdrawals;
	}
}
