package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sn.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sn.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sn.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sn.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sn.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());			
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}

		sn.close();
	}

}