package com.crosswordsolver.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;
    private String word;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        word = null;
    }

    public TrieNode getChild(char ch) {
        return children[ch - 'a'];
    }

}