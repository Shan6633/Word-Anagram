package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchWords {
    static final int SIZE = 26;
    static List<String> res = new ArrayList<>();

    // Design a trie node
    static class TrieNode {
        TrieNode[] Child = new TrieNode[SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean isWord;

        // Constructor
        public TrieNode() {
            isWord = false;
            for (int i =0 ; i< SIZE ; i++)
                Child[i] = null;
        }
    }

    static void insert(TrieNode root, String Key) {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i = 0; i < n; i++) {

            if(Key.charAt(i) >= 'a' && Key.charAt(i) <= 'z') {
                int index = Key.charAt(i) - 'a';

                if (pChild.Child[index] == null)
                    pChild.Child[index] = new TrieNode();

                pChild = pChild.Child[index];
            }

        }
        // make last node as leaf node
        pChild.isWord = true;
    }

    static void searchWord(TrieNode root, Map<Integer, Boolean> map, String str) {
        // if we found word in trie / dictionary


        if (root.isWord) {
            res.add(str);
//            System.out.println(str);
        }

        // traverse all child's of current root
        for (int K =0; K < SIZE; K++) {
            if (map.containsKey(K) && map.get(K) && root.Child[K] != null ) {
                // add current character
                char c = (char) (K + 'a');
                map.put(K, false);
                // Recursively search reaming character
                // of word in trie
                searchWord(root.Child[K], map, str + c);
                map.put(K, true);
            }
        }
    }

    static void SearchAllWords(char Arr[], TrieNode root, int n) {
        // create a 'has' array that will store all
        // present character in Arr[]
       // boolean[] Hash = new boolean[SIZE];

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0 ; i < n; i++) {
            map.put(Arr[i] - 'a', true);
        }

        // tempary node
        TrieNode pChild = root ;

        // string to hold output words
        String str = "";

        // Traverse all matrix elements. There are only
        // 26 character possible in char array
        for (int i = 0 ; i < SIZE ; i++) {
            // we start searching for word in dictionary
            // if we found a character which is child
            // of Trie root
            if (map.containsKey(i) && map.get(i) && pChild.Child[i] != null ) {
                str = str+(char)(i + 'a');
                map.put(i, false);
                searchWord(pChild.Child[i], map, str);
                str = "";
            }
        }
    }


    public static void main(String[] args) throws Exception{
        TrieNode root = new TrieNode();
        URL oracle = new URL( "https://raw.githubusercontent.com/lad/words/master/words");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        int count = 0;
        while ((inputLine = in.readLine()) != null && count < 100000){
            insert(root, inputLine.toLowerCase());
            //System.out.println(inputLine);
            count++;
        }
        in.close();

        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k'} ;
        int N = arr.length;

        SearchAllWords(arr, root, N);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
