package assignment7;

import java.util.Scanner;

import assignment7.Gautam_A07Q2.LinkedQueue;
import assignment7.Gautam_A07Q4.LinkedDeque;

public class Rail {

	public static void main(String[] args) {

		LinkedQueue<String> incomingQueue = new LinkedQueue<String>();
		LinkedQueue<String> outgoingQueue = new LinkedQueue<String>();
		LinkedDeque<String> waitingQueue = new LinkedDeque<String>();

		Scanner scan = new Scanner(System.in);
		String incomeInput;
		int size = 0;
		int count = 0;
		System.out
				.println("Please type the order of incoming car. Then DONE to stop");
		do {
			incomeInput = scan.nextLine();
			if (!incomeInput.equals("DONE")) {
				incomingQueue.enqueue(incomeInput);
				count++;
			}
			if (incomeInput.equals("DONE") && count == 0) {
				System.out
						.println("At least one incoming car needed.Please type the order of incoming car. Then DONE to stop");
			}
		} while (!(incomeInput.equals("DONE") && count != 0));

		size = incomingQueue.size();
		String outgoingInput;
		System.out
				.println("Please provide the desired output order. You should provide as many outgoing as you did incoming");
		for (int i = 0; i < size; i++) {
			outgoingInput = scan.nextLine();
			outgoingQueue.enqueue(outgoingInput);
		}

		do {
			if (waitingQueue.size() == 0) {
				if (!incomingQueue.first().equals(outgoingQueue.first())) {
					waitingQueue.enqueueFront(incomingQueue.dequeue());
				} else {
					incomingQueue.dequeue();
					outgoingQueue.dequeue();
				}
			} else {
				if (!(incomingQueue.first().equals(outgoingQueue.first()))) {
					waitingQueue.enqueueFront(incomingQueue.dequeue());

				} else {
					incomingQueue.dequeue();
					outgoingQueue.dequeue();
				}

			}
		} while (!(incomingQueue.size() == 0));

		int finalSize = outgoingQueue.size();
		for (int x = 0; x < finalSize; x++) {
			if (waitingQueue.first().equals(outgoingQueue.first())) {
				waitingQueue.dequeueFront();
				outgoingQueue.dequeue();
			} else {
				// System.out.println("Error");
				break;
			}
		}

		if (waitingQueue.size() == 0) {
			System.out
					.println("The input was successfully matched to the output!");
		} else {
			System.out
					.println("The input couldnt not be successfully matched to the output!");
		}

	}

}
