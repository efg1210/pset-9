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
	        ArrayList<String> empty = new ArrayList<String>();
	        return empty;
        }
        
	    ArrayList<String> newArray = new ArrayList<String>();
        
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
	        ArrayList<String> empty = new ArrayList<String>();
            return empty;
        }
        
        String first = values.get(((values.size() - 1) / 2) - 1);
        String middle = values.get(((values.size() - 1) / 2));
        String last = values.get(((values.size() - 1) / 2) + 1);
        
        ArrayList<String> answer = new ArrayList<String>(); 
        answer.add(first); 
        answer.add(middle); 
        answer.add(last);
        
        return answer; 
	}

	public boolean increasing(ArrayList<Integer> numbers) {
	    if (numbers == null || numbers.size() < 3) {
            return false;
        }
        
        for (int i = 1; i < numbers.size() - 1; i++) {
            if ((numbers.get(i - 1) == (numbers.get(i) - 1)) && (numbers.get(i) == (numbers.get(i + 1) - 1))) {
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
                if (numbers.get(j) == x) {
                    counter++;
                }
            }
            if (numbers.size() % 2 == 1 && numbers.get(0) == x && numbers.get(numbers.size() - 1) == x) {
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
                if (numbers.get(j) == x) {
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
            if ((numbers.get(i - 1) % 2 == 0) && (numbers.get(i) % 2 == 0) && (numbers.get(i + 1) % 2 == 0)) {
                return true;
            }
            if ((numbers.get(i - 1) % 2 == 1) && (numbers.get(i) % 2 == 1) && (numbers.get(i + 1) % 2 == 1)) {
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
                    right += numbers.get(j);
                } else {
                    left += numbers.get(j);
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
            if (values.get(i).equals(values.get(i + 1)) && !lastClump.equals(values.get(i))) {
                clumpCounter++;
            }
            lastClump = values.get(i);
        }
        
        return clumpCounter;
    }
}
