package com.zipcodewilmington;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        // should we make it check individual characters or just elements as a whole?
        for (String s : array){
            if (s.equals(value)){
                return true;
            }
        }
        // if we made it through that whole loop, then 'value' is not in there
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        //declare new array of equal length
        String[] newArray = new String[array.length];
        //iterate over original array in reverse order
        for (int i = array.length - 1; i >= 0; i--) {
            //set the value in new array, starting at the beginning, to that of the original array
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        //reverse the array (revArray)
        String[] revArray = reverse(array); // is this how we were supposed to do it?
        //iterate over revArray and see if the i element at array is the same
        for (int i = 0; i <= revArray.length - 1; i++){
            if ( !revArray[i].equals(array[i])){
                return false;
            }
        }
        // if we made it out of the loop, then they're all the same
    return true;

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        //// method 1 ////
        //create an alphabet string
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        //create a counting array
        int[] alphaCounter = new int[alpha.length()];
        // a is index 0, b is index 1, etc.
            //iterate through array
            for (int i = 0; i < array.length; i++) {
                //iterate through each string in array
                for (int j = 0; j < array[i].length(); j++) {
                    //for each occurrence of a letter, add 1 to its spot in the counter array
                    char currChar = array[i].charAt(j);
                    // if that character is a letter
                    if (Character.isLetter(currChar)){
                        //take the index of currChar and update alphaCounter at that index
                        int dex = alpha.indexOf(Character.toLowerCase(currChar));
                        alphaCounter[dex] += 1;
                    }
                }
            }
        // iterate through the counter array and if any value is 0 (i.e., wasn't in array), return false
        for (Integer i : alphaCounter){
            if (i == 0) {return false;}
        }
        //if we made it through the loop, then the array is pangramic
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        Integer numOccurrences = 0;
        //iterate over the array
        for (String s : array) {
            //if the element in the array matches that of value
            if (s.equals(value)){
                numOccurrences++;
            }
            //increase numOccurrences
        }

        return numOccurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        // I guess we only need to account for cases where there's one instance of valueToRemove in the array?
        //declare new array with one less element
        String[] newArray = new String[array.length - 1];
            for (int i = 0, j = 0; i < newArray.length; i++, j++ ) {
                // if this index contains the value that we want to remove
                if (array[i].equals(valueToRemove)) {
                    //skip this index before we copy into the new array
                    j++;
                }
                newArray[i] = array[j];
            }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //This will be like removeValue, but we need to figure out how many duplicates there are
        // so we can declare the size of the new list
        // first step: find the length of the new array (how many unique values are there?
        // iterate over array, up until length - 1 (so we're not checking out of bounds)
        int duplicates = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // if the element at the next index is the same as the current index
            if (array[i].equals(array[i + 1])) {
                //we have a duplicate
                duplicates++;
            }
        }
        //Now it's similar to removeValue, but we're looking at the next index, not at a given value
        String[] newArray = new String[array.length - duplicates];
        int offset = 0;
        for (int i = 0; i < array.length; i++) {
            // if we're not at the end && this index contains the same value as the next index
            if (i != array.length -1 && array[i].equals(array[i + 1])) {
                //we need to account for multiple duplicates (like 4 in a row)
                //skip this index before we copy into the new array
                //increase the offset
                offset++;
                continue;
            }
            newArray[i-offset] = array[i];
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        //the size of the new array is equal to the size of the old array minus the # of duplicates
        int duplicates = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // if the element at the next index is the same as the current index
            if (array[i].equals(array[i + 1])) {
                //we have a duplicate
                duplicates++;
            }
        }
        String[] newArray = new String[array.length - duplicates];
        int duplicateOffset = 0;
        int offset = 0;
        for (int i = 0; i < array.length; i++){
            // if it's not the beginning of the string and the previous element is the same as at i
            if (i != 0 && array[i].equals(array[i - 1])) {
                //increase the duplicate offset - I'll use this to keep track of where to pack into
                duplicateOffset++;
                //concatenate, accounting for the duplicate offset and the overall offset from packing other duplicates
                newArray[i - offset - duplicateOffset] += array[i];
            }
            else // if we're at the beginning of the string and/or this element is not equal to the previous one
            {
                //The overall offset is now increased by the amount of elements we just packed (if any)
                offset += duplicateOffset;
                //We're no longer in a sequence of duplicates so we can reset the duplicate offset
                duplicateOffset = 0;
                // set newArray, accounting for overall offset
                newArray[i - offset] = array[i];
            }
        }
        return newArray;
    }


}
