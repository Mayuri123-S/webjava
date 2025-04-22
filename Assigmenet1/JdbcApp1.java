package com.sunbeam;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class JdbcApp1 {
	static Scanner sc = new Scanner(System.in);
	
	public static void findAllBooks() {
		try(BookDao bookDao = new BookDao()) {
			List<Book> list = bookDao.findAll();
			for (Book book : list) {
				System.out.println(book.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findBookById() {
		try(BookDao bookDao = new BookDao()) {
			System.out.print("enter book id to find: ");
			int id = sc.nextInt();
			Book b = bookDao.findById(id);
			if(b == null)
				System.out.println("Book Not Found");
			else
				System.out.println("Found " + b.toString());
		} // bookDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void saveBook() {
		try(BookDao bookDao = new BookDao()) {
			System.out.print("enter id: ");
			int id = sc.nextInt();
			System.out.print("enter name: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("enter author: ");
			String author = sc.nextLine();
			System.out.print("enter subject: ");
			String subject = sc.next();
			System.out.print("enter price: ");
			double price = sc.nextDouble();
			Book b = new Book(id, name, author, subject, price);
			int count = bookDao.save(b);
			System.out.println("Books Inserted: " + count);
		} // bookDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateBook() {
		try(BookDao bookDao = new BookDao()) {
			System.out.print("enter book id to update: ");
			int id = sc.nextInt();
			System.out.print("enter new name: ");
			String name = sc.next();
			
			System.out.print("enter new author: ");
			String author = sc.nextLine();
			sc.nextLine();
		
			System.out.print("enter new subject: ");
			String subject = sc.next();
			sc.nextLine();
			System.out.print("enter new price: ");
			double price = sc.nextDouble();
			Book b = new Book(id, name, author, subject, price);
			int count = bookDao.update(b);
			System.out.println("Books Updated: " + count);
		} // bookDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void deleteBookById() {
		try(BookDao bookDao = new BookDao()) {
			System.out.print("Enter Book Id to delete: ");
			int bookId = sc.nextInt();
			int count = bookDao.deleteById(bookId);
			System.out.println("Books Deleted: " + count);
		} // bookDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
		public static void saveCustomer() {
			try(CustomerDao custDao = new CustomerDao()) {
				System.out.print("enter id: ");
				int id = sc.nextInt();
				System.out.print("enter name: ");
				String name = sc.next();
				System.out.print("enter email: ");
				String email = sc.next();
				System.out.print("enter mobile: ");
				String mobile = sc.next();
				System.out.print("enter address: ");
				String addr = sc.next();
				System.out.print("enter birth (yyyy-MM-dd): ");
				String birth = sc.next();
				System.out.println("Enter password : ");
				String password = sc.next();
				Date birthDate = Date.valueOf(birth);
				Customer c = new Customer(id, name, email, mobile, addr, birthDate, password);
				int count = custDao.add(c);
				System.out.println("Customer Added: " + count);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void findCustByEmail() {
			try(CustomerDao custDao = new CustomerDao())
			{
				System.out.println("Enter email id to find :");
				String email = sc.next();
				Customer c = custDao.findByEmail(email);
				if(c == null)
					System.out.println("Customer not found");
				else
					System.out.println("Found " + c.toString());
				
				
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		
		public static void findCustByEmailPass() {
			try(CustomerDao custDao = new CustomerDao()){
				System.out.println("Enter email id to find :  ");
				String email = sc.next();
				System.out.println("Enter password to find : ");
				String password = sc.next();
				Customer c = custDao.findByEmailPass(email, password);
				if(c == null) {
					System.out.println("Customer not found...");
					
				}
				else {
					System.out.println("Found " + c.toString());
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void changePasword() {
			try(CustomerDao custDao = new CustomerDao()){
				System.out.println("Enter email to Change the password : ");
				String email = sc.next();
				System.out.println("Enter New Password : ");
				String password = sc.next();
				
				Customer c = new Customer();
				
				int count = custDao.change(email, password);
				System.out.println("password Changed: " + count);
						
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void updateCustomer() {
			try(CustomerDao custDao = new CustomerDao()){
				System.out.println("Enter customer id to update : ");
				int id = sc.nextInt();
				System.out.println("Enter new name : ");
				String name = sc.next();
				System.out.println("Enter new Password : ");
				String password = sc.next();
				System.out.println("Enter new Mobile : ");
				String mobile = sc.next();
				System.out.println("Enter new address : ");
				String address = sc.next();
				System.out.println("Enter new email : ");
				String email = sc.next();
				System.out.println("Enter new birth (yyyy-MM-dd): ");
				String birth = sc.next();
				Date birthDate = Date.valueOf(birth);
				Customer c = new Customer();
				int count = custDao.update(c);
				System.out.println("Customers Updated : " + count);
				
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public static void deleteCustById() {
			try(CustomerDao custDao = new CustomerDao()){
				System.out.println("Enter Customer id to delete : ");
				int custId = sc.nextInt();
				int count = custDao.deleteById(custId);
				System.out.println("Custome deleted : " + count);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	

	public static void main(String[] args) {
		int choice = 0;
		do {
			System.out.print("\n0. Exit\n1. Find Book\n2. Show All Books\n3. Add Book\n4. Update Books\n5. Delete Book\n6. Add Customer\n7. Find Customer by Email\n.8 Find Customer by Email and Password\n9. Change Password\n10. Update Customer\n11. Delete Customer by Id\n Enter Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			
			case 0 :
				System.out.println("Bye!!\n");
				break;
				
			case 1 :
				findBookById();
				break;
				
			case 2 :
				findAllBooks();
				break;
				
			case 3 :
				saveBook();
				break;
				
			case 4 :
				updateBook();
				break;
				
			case 5 :
				deleteBookById();
				break;
				
			case 6 :
				saveCustomer();
				break;
				
			case 7 :
				findCustByEmail();
				break;
				
			case 8 :
				findCustByEmailPass();
				break;
				
			case 9 :
				changePasword();
				break;
				
			case 10 :
				updateCustomer();
				break;
				
			case 11 :
				deleteCustById();
				break;
				
			default:
				System.out.println("Are you okay ?");
					
			}	
		}while(choice != 0);
		
	}
	}
