package co.kevingomez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import static co.kevingomez.Box.boxBuilder;

public class App 
{
    public static void main( String[] args )
    {

//        System.out.println( "Hello World!" );
//        List<String> firstList = Arrays.asList("one", "two", "three");
//        List<String> secondList = Arrays.asList("three", "two", "one");
//        System.out.println(App.compareLists(firstList, secondList));
//        App.dateTest();
//    	try {
//        	App.throwExceptionDemo();
//    	} catch(Exception e) {
//    		System.out.println("Inside the catch...");
//    	}
//        System.out.println("Outside the catch...");
//        System.out.println("How tf is this still running...");
//        List<String> s = new ArrayList<>();
//        if(s.isEmpty()) {
//        	System.out.println("The list is empty dumb dumb");
//        } else {
//        	System.out.println("this list is not empty dum dum ");
//        }
        App.streamMappingDemo();
        App.flatMapDemo();
    }
    
    public static void throwExceptionDemo() throws Exception {
    	throw new Exception("msg");
    }
    
    public static boolean compareLists(List<String> listOne, List<String> listTwo) {
    	Collections.sort(listOne);
    	Collections.sort(listTwo);
    	return listOne.equals(listTwo);
    }
    
    public static void dateTest() {
    	System.out.println("start");
    	Date date = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("");
    	System.out.println(format.format(date));
    }
    //Mapping demo with streams

    //Flatmap demo
    public static void flatMapDemo(){

        List <List<Box>> boxes = Arrays.asList(Arrays.asList(boxBuilder(1, 1), boxBuilder(3, 4)));
        //flatMap maps a stream to a single stream
        List<Box> bx = boxes.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(bx);
    }

    public static void streamBasicsDemo(){

    }

    public static void enumerationAndStreams(){}

    //Mapping can only perform the mapping -> results in a stream...
    public static void streamMappingDemo(){
        //returns a stream consisting of the results of applying the given function to the elements of this stream.
        //basically it will iterate over the objects and for every object we can apply changes. You can return this new resulting collection as a list with collectors.toList
        List <Box> boxes = Arrays.asList(boxBuilder(1, 1), boxBuilder(3, 4));
        System.out.println(boxes);

        List<Box> newBoxes = boxes.stream().map(box -> {
            box.setEdges(box.getEdges() * 3);
            box.setSize(box.getSize() * 3);
            return box;
        }).collect(Collectors.toList());

        System.out.println(boxes);
        System.out.println(newBoxes);

        //literally returns the same
        List<String> strList = Arrays.asList("a", "b", "c");
        List <String> i = strList.stream().map(str -> {
            //if you use the brackets you must have a return statement else you can simply apply your simple change and it will apply it to the object and return the object implicitly
            return str.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(i);
    }
}
