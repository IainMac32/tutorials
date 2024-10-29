package midtermprac;

import javax.sound.midi.Soundbank;

public abstract class Zoo {
    public abstract void talk();

    public Zoo(){
        System.out.println("I am an ANIMALLL!!!!");
    }

    public void sleep(){
        System.out.println("ZzZzZzZ");
    }
}





























public class Zoo {
    public static void main(String[] args){
        Cat cat = new Cat();

        cat.talk();
        System.out.println(cat.sleep());
    }
}




class Cat implements Animal {
    public void talk(){
        System.out.println("meow");
    }

    public String sleep(){
        return "z";
    }
}

class Giraffe implements Animal {
        public void talk(){
            System.out.println("zzzzzzzz");
        }

        public String sleep(){
            return "zzzzz";
        }

    }
