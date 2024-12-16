//package com.example.java21.freignfunction;
//
//import java.lang.foreign.*;
//import java.lang.invoke.MethodHandle;
//import java.nio.charset.Charset;
//
///**
// * Foreign Function invoke Python code. just for fun!!!
// */
//public class ForeignFunctionFun {
//
////    Load a Native Library: Use the SymbolLookup class to load a native library (e.g., a C library):
//    static Linker linker = Linker.nativeLinker();
//    static SymbolLookup lookup = SymbolLookup.loaderLookup();
//    public static void main(String [] args) throws Throwable {
////      Lookup a Function: Find the address of a function in the loaded library:
//        // Load the Python interpreter
//        MethodHandle Py_Initialize = linker.downcallHandle(
//                lookup.find("Py_Initialize").get(),
//                FunctionDescriptor.ofVoid()
//        );
//        Py_Initialize.invokeExact();
////     Call the Function: Invoke the native function using the MethodHandle:
//        try (Arena arena = Arena.ofConfined()) {
//            MemorySegment helloWorld = arena.allocateFrom("Hello from Java!", Charset.forName("UTF8"));
//            puts.invokeExact(helloWorld);
//        }
//
//    }
//
//}
