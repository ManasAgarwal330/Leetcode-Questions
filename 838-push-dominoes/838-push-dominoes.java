class Solution {
    public String pushDominoes(String dominoes) {
        int left = 0;
        int right = 0;
        
        StringBuilder str = new StringBuilder("");
        while(right < dominoes.length()){
            
            char lchr = dominoes.charAt(left);
            char rchr = dominoes.charAt(right);
            int count = 0;
            if(lchr == '.' && rchr == 'L'){
                count = right - left + 1;
                helper('L',str,count);
                left = right+1;
            }
            else if(lchr == 'R' && rchr == 'L'){
                count = right-left-1;
                str.append(lchr);
                if(count%2 == 0){
                    helper('R',str,count/2);
                    helper('L',str,count/2);
                }else{
                    helper('R',str,count/2);
                    str.append('.');
                    helper('L',str,count/2);
                }
                str.append(rchr);
                left = right+1;
            }else if(lchr == '.' && rchr =='R'){
                count = right - left;
                helper('.',str,count);
                left = right;
            }else if(lchr == 'R' && rchr == 'R'){
                count = right - left;
                helper('R',str,count);
                left = right;
            }else if(lchr == 'L' && rchr == 'L'){
                count = right - left + 1;
                helper('L',str,count);
                left = right + 1;
            }else if(lchr == 'L' && rchr == 'R'){
                str.append('L');
                helper('.',str,right-left-1);
                left = right;
            }
            right++;
        }
        
        // System.out.println(left+" "+right);
        if(left == right){}
        else if(left == right-1){
            str.append(dominoes.charAt(right-1));
        }else{
            char lchr = dominoes.charAt(left);
            char rchr = dominoes.charAt(right-1);
            int count =0;
            // System.out.println(lchr+" "+rchr);
            if(lchr == '.' && rchr == 'L'){
                count = right - left;
                helper('L',str,count);
            }else if(lchr == '.' && rchr == '.'){
                count = right - left;
                helper('.',str,count);
            }else if(lchr == '.' && rchr == 'R'){
                count = right - left-1;
                helper('.',str,count);
                str.append(rchr);
            }else if(lchr == 'R' && rchr == 'R'){
                count = right - left;
                helper('R',str,count);
            }else if(lchr == 'R' && rchr == '.'){
                System.out.println(left+" "+right); 
                count = right - left;
                helper('R',str,count);
            }else if(lchr == 'L' && rchr == 'R'){
                str.append('L');
                helper('.',str,right-1-left-1);
                str.append('R');
            }else if(lchr == 'R' && rchr == 'L'){
                count = right-1-left-1;
                str.append(lchr);
                if(count%2 == 0){
                    helper('R',str,count/2);
                    helper('L',str,count/2);
                }else{
                    helper('R',str,count/2);
                    str.append('.');
                    helper('L',str,count/2);
                }
                str.append(rchr);
            }else if(lchr == 'L' && rchr == '.'){
                str.append('L');
                helper('.',str,right-left-1);
            }else if(lchr == 'L' && rchr == 'L'){
                helper('L',str,right-left);
            }
        }
        
        return str.toString();
    }
    
    public void helper(char ch,StringBuilder st,int count){
        while(count-- > 0){
            st.append(ch);
        }
    }
}