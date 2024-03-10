package com.crosswordsolver.components;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
