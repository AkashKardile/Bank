
import java.util.Scanner;



public class Bank {
	static class HDFC
	{
		int account_number;
		
		String name;
		
		String account_type;
		
		double balance;
		
		HDFC new_account;
		HDFC(int account_number,String name,String account_type,double balance)
		{
			this.account_number=account_number;
			
			this.name=name;
			
			this.account_type=account_type;
			
			this.balance=balance;
		}
	}
	
	static HDFC head=null;
	static HDFC tail=null;
	static HDFC current_node=null;
	static HDFC prev_node=null;
	
	
	public static boolean check_Account(int account_number)
	{
		HDFC temp=head;
		
		while(temp!=null)
		{
			if(temp.account_number==account_number)
			{
				current_node=temp;
				return true;
			}
			prev_node=temp;
			temp=temp.new_account;
		}
		return false;
	}
	
	
	
	public static void open_Account()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the account number");
		int account_number=sc.nextInt();
		sc.nextLine();
		
		
		if(check_Account(account_number))
		{
			System.out.println("The Account number that you have entered is already present.Please insert new Account number");
		}
		else
		{
			System.out.println("Enter the name of account holder");
			String name=sc.nextLine();
			
			System.out.println("Enter the Account opening balance");
			double balance=sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the Type of account");
			String account_type=sc.nextLine();
			
			
			HDFC new_bank=new HDFC(account_number, name,account_type, balance);
			
			
			if(head==null)
			{
				head=new_bank;
				tail=new_bank;
				System.out.println("Account Added Successfully");
				
			}
			
			else
			{
				tail.new_account=new_bank;
				tail=new_bank;
				System.out.println("Account Added Successfully");
			}
		}
	}
	
	
	
	public static void BalanceUpdate()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account_number for making the transaction");
		int Account_number=sc.nextInt();
		
		
		if(check_Account(Account_number))
		{
			Account_Details(Account_number);
			System.out.println("Enter the type of transaction:  Deposit/WithDraw");
			System.out.println("1. Deposit");
			System.out.println("2. WithDraw");
			
			System.out.println("Enter the choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					System.out.println("Enter the Deposit amount");
					double deposit_amount=sc.nextDouble();
					current_node.balance=current_node.balance+deposit_amount;
					System.out.println("Rs. "+deposit_amount+" "+"depoisted to a/c "+current_node.account_number+" successfully");
					Account_Details(Account_number);
					break;
				case 2:
					System.out.println("Enter the Withdraw amount");
					double withdraw_amount=sc.nextDouble();
					current_node.balance=current_node.balance-withdraw_amount;
					System.out.println("Rs. "+withdraw_amount+" "+"withdraw from a/c "+current_node.account_number+" successfully");
					Account_Details(Account_number);
					break;
				default:
					System.out.println("Please Enter the valid choice");
					break;
			}
		}
		else
		{
			System.out.println("Please Enter the valid Account Number");
		}
	
	}
	
	
	public static void Account_closing()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the account number that you have close");
		int Account_number=sc.nextInt();
		
		if(check_Account(Account_number))
		{
			if(head==null)
			{
				System.out.println("The bank does not exist any Account");
			}
			else if(current_node==head)
			{
				head=head.new_account;
				System.out.println("Account closed successfully");
			}
			else
			{
				prev_node.new_account=prev_node.new_account.new_account;
				System.out.println("Account closed successfully");
			}
		}
		else
		{
			System.out.println("Please enter the valid account number");
		}
	}
	
	
	public static void Account_Details(int Account_number)
	{

		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("----------------------**************************----------------------");
		System.out.println();
		if(check_Account(Account_number))
		{
			System.out.println("Account_Number"+":--"+current_node.account_number);
			System.out.println("Account Holder Name"+":--"+current_node.name);
			System.out.println("Account Balance"+":--"+current_node.balance);
			System.out.println("Account Type"+":--"+current_node.account_type);
		}
		else
		{
			System.out.println("Please enter the valid account number");
		}
		System.out.println();
		System.out.println("----------------------**************************----------------------");
		System.out.println();
	}
	
	public static void Balance_Enquiry()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the account number that you have search");
		int Account_number=sc.nextInt();
		System.out.println();
		System.out.println("----------------------**************************----------------------");
		System.out.println();
		if(check_Account(Account_number))
		{
			
			System.out.println("A/c "+Account_number+" Is having the balance: "+current_node.balance);
		}
		else
		{
			System.out.println("Please enter the valid account number");
		}
		
		System.out.println();
		System.out.println("----------------------**************************----------------------");
		System.out.println();
		
	}
	
	public static void Bank_All_Accounts_Details()
	{
		if(head==null)
		{
			System.out.println("The bank does not exist any Account");
		}
		else
		{
			HDFC temp=head;
			
			System.out.println();
			System.out.println("----------------------**************************----------------------");
			System.out.println();
			while(temp!=null)
			{
				System.out.println("Account_Number"+":--"+temp.account_number);
				System.out.println("Account Holder Name"+":--"+temp.name);
				System.out.println("Account Balance"+":--"+temp.balance);
				System.out.println("Account Type"+":--"+temp.account_type);
				
				System.out.println();
				System.out.println("----------------------**************************----------------------");
				System.out.println();
				
				temp=temp.new_account;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1. Open Account");
			System.out.println("2. Check Account");
			System.out.println("3. Balance Update");
			System.out.println("4. Account Closing");
			System.out.println("5. Account Details");
			System.out.println("6. Balance Enquiry");
			System.out.println("7. Bank_All_Accounts_Details");
			
			System.out.println("Enter the choice");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				open_Account();
				break;
			case 2:
				System.out.println("Enter the account number that you have to search");
				int Account_number=sc.nextInt();
				System.out.println();
				System.out.println("----------------------**************************----------------------");
				System.out.println();
				if(check_Account(Account_number))
				{
					System.out.println("Account is Exist");
				}
				else
				{
					System.out.println("Account is not Exist");
				}
				System.out.println();
				System.out.println("----------------------**************************----------------------");
				System.out.println();
				break;
			case 3:
				BalanceUpdate();
				break;
			case 4:
				Account_closing();
				break;
			case 5:
				System.out.println("Enter the account number that you have to search");
				int Account_no=sc.nextInt();
				Account_Details(Account_no);
				break;
			case 6:
				Balance_Enquiry();
				break;
			case 7:
				Bank_All_Accounts_Details();
				break;
			default:
				System.out.println("Please Enter the valid choice");
				break;
				
			}
		}
	}

}

