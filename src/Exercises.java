import java.util.*;

public class Exercises {

	public boolean commonEnd(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
			return false;
		}
		
		if (a.get(0) == b.get(0) || a.get(a.size() - 1) == b.get(b.size() - 1)) {
            return true;
        }
        
        return false;
	}
	
	public ArrayList<String> endsMeet(ArrayList<String> values, int n) {
	    if (values == null || values.size() < n || n < 0) {
            return null;
        }
        
	    ArrayList<String> newArray = new ArrayList<String>();
        
	    //ArrayList<String> firstArray /*= Arrays.copyOfRange(values, 0, n)*/;
	    for (int i = 0; i < n; i++) {
	        newArray.add(values.get(i));
	    }
	    //ArrayList<String> secondArray /*= Arrays.copyOfRange(values, (values.size() - n), values.size())*/;
        for (int i = (values.size() - n); i < values.size(); i++) {
            newArray.add(values.get(i));
        }    
//        System.arraycopy(firstArray, 0, newArray, 0, firstArray.size());
//        System.arraycopy(secondArray, 0, newArray, firstArray.size(), secondArray.size());
		
		return newArray;	// default return value to ensure compilation
	}
	
	public int difference(ArrayList<Integer> numbers) {
	    if (numbers == null || numbers.size() < 1) {
            return -1;
        }
        
        Collections.sort(numbers);
        
        return (numbers.get(numbers.size() - 1) - numbers.get(0));
	}
	
	public double biggest(ArrayList<Double> numbers) {
	    if (numbers == null || numbers.size() < 3 || numbers.size() % 2 == 0) {
            return -1;
        }
        
        for (double value : numbers) {
            if (value < 0) {
                return -1;
            }
        }
        
        double first = numbers.get(0);
        double middle = numbers.get((numbers.size() -1) / 2);
        double last = numbers.get(numbers.size() - 1);
        
        if (first > middle || first == middle) {
            if (first > last || first == last) {
                return first;
            }
        }
        
        if (middle > first || middle == first) {
            if (middle > last || middle == last) {
                return middle;
            }
        }
        
        if (last > first || last == first) {
            if (last > middle || last == middle) {
                return last;
            }
        }
                
        return -1;
	}
	
	public ArrayList<String> middle(ArrayList<String> values) {
	    if (values == null || values.size() < 3 || values.size() % 2 == 0) {
            return new String[0];
        }
        
        String first = values[((values.size() - 1) / 2) - 1];
        String middle = values[((values.size() - 1) / 2)];
        String last = values[((values.size() - 1) / 2) + 1];
        
        return new String[] {first, middle, last};
	}

	public boolean increasing(ArrayList<Integer> numbers) {
	    if (numbers == null || numbers.size() < 3) {
            return false;
        }
        
        for (int i = 1; i < numbers.size() - 1; i++) {
            if ((numbers[i - 1] == (numbers[i] - 1)) && (numbers[i] == (numbers[i + 1] - 1))) {
                return true;
            }
        }
        
        return false;
	}
	
	public boolean everywhere(ArrayList<Integer> numbers, int x) {
	    if (numbers == null || numbers.size() < 1) {
            return false;
        }
        
        //checks if everything is x
        int counter = 0;
        for (int value : numbers) {
            if (value == x) {
                counter++;
            }
        }
        if (counter == numbers.size()) {
            return true;
        }
        
        //checks if every other is x
        counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < numbers.size(); j += 2) {
                if (numbers[j] == x) {
                    counter++;
                }
            }
            if (numbers.size() % 2 == 1 && numbers[0] == x && numbers[numbers.size() - 1] == x) {
                if (counter == ((numbers.size() + 1) / 2)) {
                    return true;
                }
            } else {
                if (counter == numbers.size() / 2) {
                    return true;
                }
            }
        }
                
        //checks if every third is x
        counter = 0;
        for (int i = 0; i < 3; i++) {
            counter = 0;
            for (int j = i; j < numbers.size(); j += 3) {
                if (numbers[j] == x) {
                    counter++;
                }
            }
            if (counter == numbers.size() / 3) {
                return true;
            }
        }
        
        return false;
	}
	
	public boolean consecutive(ArrayList<Integer> numbers) {
	    if (numbers == null || numbers.size() < 3) {
            return false;
        }
        
        for (int i = 1; i < numbers.size() - 1; i++) {
            if ((numbers[i - 1] % 2 == 0) && (numbers[i] % 2 == 0) && (numbers[i + 1] % 2 == 0)) {
                return true;
            }
            if ((numbers[i - 1] % 2 == 1) && (numbers[i] % 2 == 1) && (numbers[i + 1] % 2 == 1)) {
                return true;
            }
        }
        
        return false;
	}
	
	public boolean balance(ArrayList<Integer> numbers) {
	    if (numbers == null || numbers.size() < 2) {
            return false;
        }
        
        for (int i = 0; i < numbers.size(); i++) {
            int right = 0;
            int left = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (j < i) {
                    right += numbers[j];
                } else {
                    left += numbers[j];
                }
            }
            if (right == left) {
                return true;
            }
        }
        
        return false;
	}
	
	public int clumps(ArrayList<String> values) {
	    if (values == null) {
            return -1;
        }
        for (String s : values) {
            if (s == null) {
                return -1;
            }
        }
        if (values.size() == 0 || values.size() == 1) {
            return 0;
        }
        
        int clumpCounter = 0;
        String lastClump = "";
        
        for (int i = 0; i < values.size() - 1; i++) {
            if (values[i].equals(values[i + 1]) && !lastClump.equals(values[i])) {
                clumpCounter++;
            }
            lastClump = values[i];
        }
        
        return clumpCounter;
    }
	}
}
