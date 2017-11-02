/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    String z;
    private Random random = new Random();
    ArrayList<String> wordList=new ArrayList<>();
    HashSet<String> wordSet= new HashSet<>();
    HashMap<String,ArrayList> lettersToWords= new HashMap<>();
    public AnagramDictionary(Scanner sc) throws IOException {

        while(sc.hasNext()) {
                wordList.add(sc.nextLine());
        }

    }

    public boolean isGoodWord(String word, String base) {

        /*if(word.equals(base))
        {
            return false;
        }
        else if(word.contains(base))
        {
            return false;
        }

       *//* if(word.length()>base.length()){
             if(word.indexOf(base)==0||word.indexOf(base)==(word.length()-base.length()-1)){
                return false;
            }
        }*/


        return true;


    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();


        ListIterator<String> i=wordList.listIterator();

        while (i.hasNext())
        {
            String an=i.next();
            if(sortLetters(targetWord).equals(sortLetters(an)))
            {
                if(an.compareToIgnoreCase(targetWord)==0)
                    continue;

                result.add(an);
            }
        }
        lettersToWords.put(sortLetters(targetWord),result);


        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result=new ArrayList<>();
        for(char ch= 'a';ch<='z';ch++){
            ArrayList<String> resultTmp = new ArrayList<String>();
            String str=word.concat(Character.toString(ch));
            ListIterator<String> i=wordList.listIterator();
            while (i.hasNext())
            {
                String an=i.next();
                if(sortLetters(str).equals(sortLetters(an)))
                {
                    resultTmp.add(an);

                }


            }
            lettersToWords.put(sortLetters(str),resultTmp);
            result.addAll(resultTmp);


        }


        return result;
    }

    public String pickGoodStarterWord() {
        return "badge";
    }

    public String sortLetters(String z)
    {
        char[] charArray =z.toCharArray();
        z="";

        for(int i=0;i<charArray.length;i++){
            for(int j=i+1;j<charArray.length;j++){
                if (charArray[j] < charArray[i]) {
                    char temp = charArray[i];
                    charArray[i]=charArray[j];
                    charArray[j]=temp;
                }
            }
        }
        return String.valueOf(charArray);
    }


}
