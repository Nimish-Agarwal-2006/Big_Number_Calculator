package arbitraryarithmetic;


public class AInteger{

    public String value;
    //Thge empty constructor.
    public AInteger(){
        this.value="0";
    }
    //The constructor which takes string.
    public AInteger(String s){
        this.value=s;
    }
    //The constructor which copies an object to another object.
    public AInteger(AInteger other){
        this.value=other.value;
    }
    //Function that returns the object.
    public static AInteger parse(String s)
    {
        return new AInteger(s);
    }
    //Function to remove excessive initial zeros like 001 to 1 and -0123 to -123
    public String remove_initial_zeros(String s)
    {
        int i=0;
        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)!='0')
            break;
        }
        s=s.substring(i);
        return s;
    }
    public String remove_final_zeros(String s)
    {
        int i;
        for(i=s.length()-1;i>0;i--)
        {
            if(s.charAt(i)!='0')
            break;
        }
        s=s.substring(0,i+1);
        return s;
    }

    //Function that checks which number is greator
    //This function returns true if the second number is greator
    //Here bothg numbers are positive
    public boolean neg_check(String s)
    {
        boolean negcheck=false;
        //if the length of the number is greator the number is greator
        if(s.length()>this.value.length())
        {
            negcheck=true;
        }
        //if the length is same then the first different number decides which is greator
        else if(s.length()==this.value.length())
        {
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>this.value.charAt(i))
                {
                    negcheck=true;
                    break;
                }
                if(this.value.charAt(i)>s.charAt(i))
                {
                    break;
                }
            }
        }
        return negcheck;
    }

    //Function that adds two positive infinitely ranged integers
    public String positive_add(String s)
    {
        String after="";
        int max= Math.max(this.value.length(),s.length());
        int count=0;
        //Loop through them adding one by one and taking carry
        for(int i=0;i<max+1;i++)
        {
            if(this.value.length()>i)
            {
                count+=(int)(this.value.charAt(this.value.length()-i-1)-'0');
            }
            if(s.length()>i)
            {
                count+=(int)(s.charAt(s.length()-i-1)-'0');
            }
            after=(char)(count%10+'0')+after;
            count=count/10;
        }
        after=this.remove_initial_zeros(after);
        return after;
    }
    //Function to subtract a smaller positive number from a greator positive number
    public String positive_sub(String s)
    {
        String after="";
        int max= Math.max(this.value.length(),s.length());
        int count=0;
        //Looping one by one taking carry
        for(int i=0;i<max+1;i++)
        {
            if(this.value.length()>i)
            {
                count+=(int)(this.value.charAt(this.value.length()-i-1)-'0');
            }
            if(s.length()>i)
            {
                count-=(int)(s.charAt(s.length()-i-1)-'0');
            }
            if(count<0)
            {
                count+=10;
                after=(char)(count+'0')+after;
                count=-1;
            }
            else
            {
                after=(char)(count+'0')+after;
                count=0;
            }
        }
        after=this.remove_initial_zeros(after);
        return after;
    }
    public String positive_multi(String s)
    {
        AInteger after=new AInteger();
        String intermediate="";
        int count=0;
        int carry=0;
        for(int i=0;i<s.length();i++)
        {
            
            for(int j=0;j<this.value.length();j++)
            {
                
                count=(int)(s.charAt(s.length()-i-1)-'0');
                count*=(int)(this.value.charAt(this.value.length()-j-1)-'0');
                count+=carry;
                intermediate=(char)(count%10+'0')+intermediate;
                carry=count/10;
                //System.out.println("HI " + intermediate +" "+ count +" "+ carry);
                
                
            }
            intermediate=(char)(carry+'0')+intermediate;
            carry = 0;
            for(int k=0;k<i;k++)
                {
                    intermediate=intermediate+'0';
                }
                //System.out.println(intermediate);
                intermediate=this.remove_initial_zeros(intermediate);
                after.value=after.positive_add(intermediate);
                intermediate="";
            
        }
        after.value=this.remove_initial_zeros(after.value);
        return after.value;

    }
    public String positive_div(String s)
    {
        int len=s.length();
        AInteger other=new AInteger(s);
        if(this.value.length()<len)
        {
            return "0";
        }
        AInteger inter=new AInteger();
        String after="";
        inter.value=this.value.substring(0,len);
        int j=0;
        for(int i=0;i<=this.value.length()-len;i++)
        {
            while(other.neg_check(inter.value)||inter.value.equals(other.value))
            {
                inter.value=inter.positive_sub(other.value);
                j++;
            }
            after=after+(char)(j+'0');
            j=0;
            if(i!=this.value.length()-len)
            {
                inter.value=inter.value+this.value.charAt(len+i);
            }
            
            inter.value=this.remove_initial_zeros(inter.value);
        }
        return after;
    }

    public AInteger add(AInteger other)
    {
        //There are 4 cases
        //1. Both Numbers are positive.
        //2. First number is negative.
        //3. Second number is negative.
        //4. Both Numbers are negative.

        String after="";

        //Case 1:
        if(this.value.charAt(0)!='-' && other.value.charAt(0)!='-')
        {
            after=this.positive_add(other.value);
        }
        //Case 2:
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            if(!other.neg_check(this.value))
            {
                after=other.positive_sub(this.value);
            }
            else
            {
                after=this.positive_sub(other.value);
                after='-'+after;
            }
            this.value='-'+this.value;
        }
        //Case:3
        else if(this.value.charAt(0)!='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            if(!this.neg_check(other.value))
            {
                after=this.positive_sub(other.value);
            }
            else
            {
                after=other.positive_sub(this.value);
                after='-'+after;
            }
            
            other.value='-'+other.value;
        }
        //Case:4
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            this.value=this.value.substring(1);
            after=this.positive_add(other.value);
            other.value='-'+other.value;
            this.value='-'+this.value;
            after='-'+after;
        }
        return new AInteger(after);
        //For the first case create a function to add positive numbers.
        
    }





    public AInteger sub(AInteger other)
    {
        //There are 4 cases
        //1. Both Numbers are positive.
        //2. First number is negative.
        //3. Second number is negative.
        //4. Both Numbers are negative.

        String after="";

        //Case 1:
        if(this.value.charAt(0)!='-' && other.value.charAt(0)!='-')
        {
            if(!this.neg_check(other.value))
            {
                after=this.positive_sub(other.value);
            }
            else
            {
                after=other.positive_sub(this.value);
                after='-'+after;
            }
            
        }
        //Case 2:
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=other.positive_add(this.value);
            after='-'+ after;
            this.value='-'+this.value;
        }
        //Case:3
        else if(this.value.charAt(0)!='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.positive_add(other.value);
            other.value='-'+other.value;
        }
        //Case:4
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            this.value=this.value.substring(1);
            if(!other.neg_check(this.value))
            {
                after=other.positive_sub(this.value);
            }
            else
            {
                after=this.positive_sub(other.value);
                after='-'+after;
            }
            other.value='-'+other.value;
            this.value='-'+this.value;
        }
        return new AInteger(after);
        //For the first case create a function to add positive numbers.
        
    }

    public AInteger multi(AInteger other)
    {
        String after="";
        if(this.value.charAt(0)=='-'&&other.value.charAt(0)=='-')
        {
        
            this.value=this.value.substring(1);
            other.value=other.value.substring(1);
            after=this.positive_multi(other.value);
            this.value='-'+this.value;
            other.value='-'+other.value;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.positive_multi(other.value);
            other.value='-'+other.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)=='-'&&other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=this.positive_multi(other.value);
            this.value='-'+this.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)!='-')
        {
            after=this.positive_multi(other.value);
        }
        return new AInteger(after);
    }


    public AInteger div(AInteger other)
    {
        String after="";
        if(this.value.charAt(0)=='-'&&other.value.charAt(0)=='-')
        {
        
            this.value=this.value.substring(1);
            other.value=other.value.substring(1);
            after=this.positive_div(other.value);
            this.value='-'+this.value;
            other.value='-'+other.value;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.positive_div(other.value);
            other.value='-'+other.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)=='-'&&other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=this.positive_div(other.value);
            this.value='-'+this.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)!='-')
        {
            after=this.positive_div(other.value);
        }
        return new AInteger(after);
    }





    public static void main(String args[])
    {
        AInteger a=new AInteger("1");
        AInteger b=new AInteger("1");
        System.out.println(a.sub(b).value);
    }

}
   