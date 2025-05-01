package arbitraryarithmetic;


public class AFloat{

    public String value;

    public AFloat()
    {
        this.value="0.0";
    }

    public AFloat(String s)
    {
        this.value=s;
    }

    public AFloat(AFloat other)
    {
        this.value=other.value;
    }
    public boolean neg_check(String s)
    {
        AInteger a=new AInteger(this.give_pre_decimal(this.value));
        AInteger b=new AInteger(this.give_pre_decimal(s));
        if(!a.value.equals(b.value))
        {
            return a.neg_check(b.value);
        }
        else
        {
            a.value=this.give_post_decimal(this.value);
            b.value=this.give_post_decimal(s);
            return b.value.compareTo(a.value)>0;

        }

        
    }
    public static boolean valid_check(String s)
    {
        int check=0;
        int check2=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
            {
                check++;
            }
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
            {
                check2++;
            }
        }
        if(check==1&&check2==1)
        {
            return true;
        }
        if(check==0&&check2==0)
        {
            return true;
        }
        return false;
    }
    public String give_pre_decimal(String s)
    {
        String after="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
            {
                break;
            }
            after=after+s.charAt(i);
        }
        return after;
    }
    public String give_post_decimal(String s)
    {
        String after="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
            {
                after=s.substring(i+1);
            }
        }
        return after;
    }
    public String float_add(String s)
    {
        String after="";
        String after_post="";
        AInteger pre_decimal1=new AInteger(this.give_pre_decimal(this.value));
        AInteger pre_decimal2=new AInteger(this.give_pre_decimal(s));
        AInteger post_decimal1=new AInteger(this.give_post_decimal(this.value));
        AInteger post_decimal2=new AInteger(this.give_post_decimal(s));
        pre_decimal1.value=pre_decimal1.positive_add(pre_decimal2.value);
        int c=Math.max(post_decimal1.value.length(),post_decimal2.value.length());
        if(post_decimal1.value.length()<c)
        {
            while(post_decimal1.value.length()<c)
            {
                post_decimal1.value=post_decimal1.value+'0';
            }
        }
        if(post_decimal2.value.length()<c)
        {
            while(post_decimal2.value.length()<c)
            {
                post_decimal2.value=post_decimal2.value+'0';
            }
        }
        after_post=post_decimal1.positive_add(post_decimal2.value);
        if(after_post.length()<c)
        {
            while(after_post.length()<c)
            {
                after_post='0'+after_post;
            }
        }
        else if(after_post.length()>c)
        {
            pre_decimal1.value=pre_decimal1.positive_add(after_post.substring(0,after_post.length()-c));
            after_post=after_post.substring(after_post.length()-c);
        }
        after=pre_decimal1.value+'.'+after_post;
        return after;
    }
    public String float_sub(String s)
    {
        String after="";
        String after_post="";
        AInteger pre_decimal1=new AInteger(this.give_pre_decimal(this.value));
        AInteger pre_decimal2=new AInteger(this.give_pre_decimal(s));
        AInteger post_decimal1=new AInteger(this.give_post_decimal(this.value));
        AInteger post_decimal2=new AInteger(this.give_post_decimal(s));
        pre_decimal1.value=pre_decimal1.positive_sub(pre_decimal2.value);
        int check=0;
        if(!pre_decimal1.value.equals("0"))
        {
            pre_decimal1.value=pre_decimal1.positive_sub("1");
            check=1;
        }
        int c=Math.max(post_decimal1.value.length(),post_decimal2.value.length());
        if(post_decimal1.value.length()<c)
        {
            while(post_decimal1.value.length()<c)
            {
                post_decimal1.value=post_decimal1.value+'0';
            }
        }
        if(post_decimal2.value.length()<c)
        {
            while(post_decimal2.value.length()<c)
            {
                post_decimal2.value=post_decimal2.value+'0';
            }
        }
        if(check==1)
        {
            post_decimal1.value='1'+post_decimal1.value;
        }
       
        after_post=post_decimal1.positive_sub(post_decimal2.value);
        if(after_post.length()<c)
        {
            while(after_post.length()<c)
            {
                after_post='0'+after_post;
            }
        }
        else if(after_post.length()>c)
        {
            pre_decimal1.value=pre_decimal1.positive_add(after_post.substring(0,after_post.length()-c));
            after_post=after_post.substring(after_post.length()-c);
        }
        after=pre_decimal1.value+'.'+after_post;
        return after;

    }
    public String float_multi(String s)
    {
        int i=0,j=0;
        AInteger without_decimal1=new AInteger();
        AInteger without_decimal2=new AInteger();
        for(i=0;i<this.value.length();i++)
        {
            if(this.value.charAt(this.value.length()-i-1)=='.')
            {
                break;
            }

        }
        without_decimal1.value=this.give_pre_decimal(this.value)+this.give_post_decimal(this.value);
        for(j=0;j<s.length();j++)
        {
            if(s.charAt(s.length()-j-1)=='.')
            {
                break;
            }

        }
        without_decimal2.value=this.give_pre_decimal(s)+this.give_post_decimal(s);
        String after=without_decimal1.positive_multi(without_decimal2.value);
        while(after.length()<=i+j+1)
        {
            after='0'+after;
        }
        without_decimal1.value=AInteger.remove_initial_zeros(after.substring(0,after.length()-i-j));
        without_decimal2.value=without_decimal2.remove_final_zeros(after.substring(after.length()-i-j));
        after=without_decimal1.value+'.'+without_decimal2.value;
        return after;
    }
    public String float_div(String s)
    {
        AInteger pre_decimal1=new AInteger(this.give_pre_decimal(this.value));
        AInteger pre_decimal2=new AInteger(this.give_pre_decimal(s));
        AInteger post_decimal1=new AInteger(this.give_post_decimal(this.value));
        AInteger post_decimal2=new AInteger(this.give_post_decimal(s));
        int c=Math.max(post_decimal1.value.length(),post_decimal2.value.length());
        if(post_decimal1.value.length()<c)
        {
            while(post_decimal1.value.length()<c)
            {
                post_decimal1.value=post_decimal1.value+'0';
            }
        }
        if(post_decimal2.value.length()<c)
        {
            while(post_decimal2.value.length()<c)
            {
                post_decimal2.value=post_decimal2.value+'0';
            }
        }
        AInteger divident=new AInteger(pre_decimal1.value+post_decimal1.value);
        AInteger divisor=new AInteger(pre_decimal2.value+post_decimal2.value);
        String after=divident.positive_div(divisor.value);
        int j=0;
        for(int i=0;i<1000;i++)
        {
            if(divident.positive_div(divisor.value).equals("0"))
            {
                j=i+1;
            }
            divident.value=divident.value+'0';
            
        }
        String after1000=divident.positive_div(divisor.value);
        while(j!=0)
        {
            after1000='0'+after1000;
            j-=1;
        }
        String a=after1000.substring(after.length());
        a=AInteger.remove_final_zeros(a);
        if(a.length()>30)
        {
            a=a.substring(0,30);
        }
        after1000=AInteger.remove_initial_zeros(after1000.substring(0,after.length()))+'.'+a;
        return after1000;
    }

    public AFloat sub(AFloat other)
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
                after=this.float_sub(other.value);
            }
            else
            {
                after=other.float_sub(this.value);
                after='-'+after;
            }
            
        }
        //Case 2:
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=other.float_add(this.value);
            after='-'+ after;
            this.value='-'+this.value;
        }
        //Case:3
        else if(this.value.charAt(0)!='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.float_add(other.value);
            other.value='-'+other.value;
        }
        //Case:4
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            this.value=this.value.substring(1);
            if(!other.neg_check(this.value))
            {
                after=other.float_sub(this.value);
            }
            else
            {
                after=this.float_sub(other.value);
                after='-'+after;
            }
            other.value='-'+other.value;
            this.value='-'+this.value;
        }
        return new AFloat(after);
        //For the first case create a function to add positive numbers.
        
    }

    public AFloat add(AFloat other)
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
            after=this.float_add(other.value);
        }
        //Case 2:
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            if(!other.neg_check(this.value))
            {
                after=other.float_sub(this.value);
            }
            else
            {
                after=this.float_sub(other.value);
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
                after=this.float_sub(other.value);
            }
            else
            {
                after=other.float_sub(this.value);
                after='-'+after;
            }
            
            other.value='-'+other.value;
        }
        //Case:4
        else if(this.value.charAt(0)=='-' && other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            this.value=this.value.substring(1);
            after=this.float_add(other.value);
            other.value='-'+other.value;
            this.value='-'+this.value;
            after='-'+after;
        }
        return new AFloat(after);
        //For the first case create a function to add positive numbers.
        
    }

    public AFloat multi(AFloat other)
    {
        String after="";
        if(this.value.charAt(0)=='-'&&other.value.charAt(0)=='-')
        {
        
            this.value=this.value.substring(1);
            other.value=other.value.substring(1);
            after=this.float_multi(other.value);
            this.value='-'+this.value;
            other.value='-'+other.value;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.float_multi(other.value);
            other.value='-'+other.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)=='-'&&other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=this.float_multi(other.value);
            this.value='-'+this.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)!='-')
        {
            after=this.float_multi(other.value);
        }
        return new AFloat(after);
    }

    public AFloat div(AFloat other)
    {
        String after="";
        if(this.value.charAt(0)=='-'&&other.value.charAt(0)=='-')
        {
        
            this.value=this.value.substring(1);
            other.value=other.value.substring(1);
            after=this.float_div(other.value);
            this.value='-'+this.value;
            other.value='-'+other.value;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)=='-')
        {
            other.value=other.value.substring(1);
            after=this.float_div(other.value);
            other.value='-'+other.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)=='-'&&other.value.charAt(0)!='-')
        {
            this.value=this.value.substring(1);
            after=this.float_div(other.value);
            this.value='-'+this.value;
            after='-'+after;
        }
        else if(this.value.charAt(0)!='-'&&other.value.charAt(0)!='-')
        {
            after=this.float_div(other.value);
        }
        return new AFloat(after);
    }
    
}
