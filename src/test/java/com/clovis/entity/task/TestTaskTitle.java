
package com.clovis.entity.task;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * TestTaskDescription
 */
public class TestTaskTitle{

    private BuildTaskTitle build;


    @BeforeEach 
    void setup(){
        build = new BuildTaskTitle();
    }


    static Stream<String> provideData(){

        String maxSizeString = ""; 

        for(int i = 0; i < TaskTitle.getMaxSize(); i++){
            maxSizeString += "a";
        }


        return Stream.of(maxSizeString);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    @DisplayName("Test Valid descriptions")
    void testMainCase(String title){
        assertDoesNotThrow(() -> build.setTitle(title).build(), "input : " + title);
    } 
    
    @ParameterizedTest 
    @NullSource 
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("Test blank source")
    void testAlternativeCase(String title){
        assertThrows(IllegalArgumentException.class, () -> build.setTitle(title).build(), "input : " + title);

    }
}
