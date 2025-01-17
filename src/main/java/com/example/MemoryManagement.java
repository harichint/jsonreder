package com.example;

import com.example.pojo.Person;

public class MemoryManagement {
    public static void main(String [] args) { //- block of memory for main in stack
        int primitiveVar = 10; // value is stored in stack - main scope/portion ofmain in stack
        Person personObj = new Person(); //Object created in Heap but the reference in stack - scope of main
        String str = "Hello";//string literal in Heap is in stringpool and referenceis in stack - scope is main method
        MemoryManagement memObj = new MemoryManagement();//object create in HEAP, reference in stack - scope is main method
        memObj.excute(personObj);

    }
    public void excute(Person p) {// another block from stack for execute method scope
        Person p1 = p; //object created in Heap, reference in - stack frame of execute scope
        String st1 = "Hello"; // String litereal on Heap string pool reuse , referecne in stack is create- execute method blockscope
        String st2 = new String("Hello");//new string object in Heap, store reference in stack scope excute
    }//scope is closed so remove all in execute and corresponding references in heap removed.

}//all main scope on stack removed and references in heap as well.
