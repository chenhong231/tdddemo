package com.legacycode.chapter6.sproutmethod.after;

import com.legacycode.chapter6.sproutmethod.model.Entry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TransactionGate {

    private List<Entry> list = new ArrayList<>();

    public void postEntries(List<Entry> entries) {
        //该变量侵入性相当强
        //修改之后，依然出现了临时变量，但是现在代码清晰多了。
        List<Entry> entriesToAdd = uniqueEntries(entries);
        for(Iterator it = entriesToAdd.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            entry.postDate();;
        }
        add(entries);
    }

    private List uniqueEntries(List entries) {
        List result = new ArrayList();
        for(Iterator it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            if(!hasEntry(entry)) {
                result.add(entry);
            }
        }
        return result;
    }

    private boolean hasEntry(Entry entry) {
        return list.contains(entry);
    }

    private void add(List<Entry> entries) {
        for(Entry entry : entries) {
            list.add(entry);
        }
    }
}
