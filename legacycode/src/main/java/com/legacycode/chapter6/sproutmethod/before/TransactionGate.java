package com.legacycode.chapter6.sproutmethod.before;

import com.legacycode.chapter6.sproutmethod.model.Entry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TransactionGate {

    private List<Entry> list = new ArrayList<>();

    public void postEntries(List<Entry> entries) {
        //该变量侵入性相当强
        //在添加的新代码与原来的老代码之间没有任何分界，导致两个操作混在一起了：一个日期发送，另外一个是重复检查
        List<Entry> entriesToAdd = new LinkedList();
        for(Iterator it = entries.iterator(); it.hasNext();) {
            Entry entry = (Entry) it.next();
            if(!hasEntry(entry)) {
                entry.postDate();;
                entriesToAdd.add(entry);
            }
        }
        add(entries);
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
