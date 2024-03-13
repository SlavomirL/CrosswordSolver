package com.crosswordsolver.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new TrieNode();
            }
            node = node.getChildren()[index];
        }
        node.setEndOfWord(true);
        node.setWord(word);
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return node != null && node.isEndOfWord();
    }

}