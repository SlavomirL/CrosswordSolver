package com.crosswordsolver.components;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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