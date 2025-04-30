



import java.io.Serializable;
import java.util.Iterator;
public class AnimalList implements Iterable<Animal>, Serializable {
	AnimalNode head; 
	AnimalNode tail; 	
	int size;  	
	public AnimalList() { 		
		head = null; 		
		tail = null; 		
		size = 0; 	}  

	public int size() { 	
		return size; 	
	}  	

	public boolean isEmpty() {
		return head == null; 	
	}

	public void addFirst(Animal animal) { 
		AnimalNode newNode = new AnimalNode(animal);
		if (head == null) {
			head = newNode; 
			tail = newNode; 		
		} else { 
			newNode.next = head;
			head = newNode; 		
		} 	
		size++; 	} 

	public void addLast(Animal animal) { 
		AnimalNode newest = new AnimalNode(animal); 		
		if (isEmpty()) {
			head = newest; 		
		} else {
			tail.next = newest; 		
		} 		
		tail = newest; 	
		size++; 	
	}

	public void add(int index, Animal animal) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		AnimalNode newNode = new AnimalNode(animal);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else if (index == size) {
			tail.next = newNode;
			tail = newNode;
		} else {
			AnimalNode current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}

		size++;
	}


	public Animal removeFirst() {  
		if (isEmpty()) { 	
			return null; 
		}
		Animal ani = head.animal; 
		head = head.next; 		
		if (head == null) { 
			tail = null;
		} 		
		size--; 		
		return ani; 	
	}  	

	public Animal removeLast() {  
		if (isEmpty()) {
			return null; 
		}
		Animal anim = tail.animal;
		AnimalNode current = head; 	
		AnimalNode prev = null;
		while (current.next != null) {
			prev = current; 	
			current = current.next; 	
		}
		if (prev == null) { 
			head = null; 	
			tail = null; 
		} else {
			prev.next = current.next;
			tail = prev; 	
		}
		size--; 		
		return anim; 	
	}

	public Animal remove(int index){ 	
		if (isEmpty()) 			
			throw new IndexOutOfBoundsException(); 		
		if (index > size) 		
			throw new IndexOutOfBoundsException();
		AnimalNode current = head; 	
		AnimalNode prev = null;
		int i = 0; 		
		while (current.next != null && i < index) { 	
			prev = current; 
			current = current.next; 
			i++; 		
		}
		if (current.next == null && i != index) {
			return null; 
		} else { 		
			if (current == head) { 
				head = current.next; 			
			} else { 
				prev.next = current.next; 			}
			size--; 	
			if (size == 0) {
				tail = null; 			
				head = null; 			
			} 
		} 	
		return current.animal; 
	}

	public Animal getFirst(){
		return head.animal; 
	}  

	public Animal getLast() {
		return tail.animal; 	
	} 

	public Animal get(int index){
		AnimalNode current = head; 		
		int i = 0; 
		if (index < size) {
			while (current.next != null && i < index) {
				current = current.next;
				i++; 			
			}
			return current.animal; 	
		} else { 		
			throw new IndexOutOfBoundsException();
		}
	}  	

	public Animal set(int index, Animal animal) {
		AnimalNode current = head;
		int i = 0; 	
		if (index < size) { 		
			while (current.next != null && i < index) { 
				current = current.next; 	
				i++; 			
			}
			Animal anim = current.animal;
			current.animal = animal; 
			return anim;
		} else {
			throw new IndexOutOfBoundsException(); 		
		}
	}  


	public String toString() {
		AnimalNode current = head; 
		String s = "";
		while (current != null) {
			s = s + current.animal.toString() + "\n"; 	
			current = current.next; 		
		}
		return s; 
	} 

	public AnimalList getHungryAnimals() {
		AnimalList HungryAnim = new AnimalList();
		AnimalNode current = head; 	
		while (current != null) {
			if (current.animal.getEnergy() < 50) {
				HungryAnim.addFirst(current.animal);
			} 			
			current = current.next; 		
		}
		return HungryAnim; 
	}

	public AnimalList getStarvingAnimals() { 
		AnimalList StarvingAnim = new AnimalList(); 	
		AnimalNode current = head; 	
		while (current != null) { 		
			if (current.animal.getEnergy() < 17) { 	
				StarvingAnim.addFirst(current.animal); 
			} 
			current = current.next;
		} 
		return StarvingAnim;
	}  

	public Iterator<Animal> iterator() {
		return new MyIterator(); 	
	} 
	public double getRequiredFood() {
		double FoodSum = 0;
		for (Animal animal : this) {
			double requiredFood = 100 - animal.getEnergy();
			FoodSum += Math.min(requiredFood, animal.getMealAmount());
		}
		return FoodSum;
	}

	public AnimalList getAnimalsInBarn() {
		AnimalList barnAnimals = new AnimalList();
		AnimalNode current = head;
		double X1 = 450;
		double X2 = 50;
		double X3 = 550;
		double X4 = 150;

		while (current != null) {

			if (current.animal.getX() >= X1 && current.animal.getX() <= X3 && current.animal.getY() >= X2 && current.animal.getY() <= X4) {
				barnAnimals.addLast(current.animal);
			}
			current = current.next;
		}
		return barnAnimals.isEmpty() ? null : barnAnimals;
	}

	class AnimalNode implements Serializable{
		Animal animal; 	
		AnimalNode next;  

		public AnimalNode(Animal animal){
			this.animal = animal; 		
			next = null; 		
		}
	}  	

	class MyIterator implements Iterator<Animal> {
		AnimalNode current = head;
		
		public Animal next() {
			Animal a = current.animal;
			current = current.next; 	
			return a;
		}
		public boolean hasNext() { 
			return current != null; 		}  
	} 

	public AnimalList getByType(Class<?> type) {
		AnimalList resultList = new AnimalList();
		AnimalNode current = head;
		while (current != null) {
			if (type.isInstance(current.animal)) {
				resultList.addLast(current.animal);
			}
			current = current.next;
		}
		return resultList;
	}
}







