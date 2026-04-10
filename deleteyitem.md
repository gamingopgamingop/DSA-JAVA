
void deletebyitem(int item){
step 1 : start
step 2 : if(start.data == item)
       : start = start.next
step 3: node q = start, p = start.next
step 4: while(q != null)
        : p=q
        :q=q.next
       : if(p.data == item)
       : q.next = p.next
}
step 5 : end

void deletebyposition(int position){
step 1 : start
step 2 : if(position == 1)
       : start = start.next
step 3 : node q = start, p = start.next
step 4 : while(q != null)
        : p=q
        :q=q.next
        : if(p != null)
        : q.next = p.next
}
step 5 : end
