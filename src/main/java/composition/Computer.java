package composition;

public class Computer {
    private Proccessor proccessor;
    private Memory memory;


    public Computer(Proccessor aProccessor,  Memory aMemory){
        proccessor = aProccessor;
        memory = aMemory;
    }

    public Computer(){
        proccessor = new Proccessor();
        memory = new Memory(555);
    }

    public Proccessor getProccessor() {
        return proccessor;
    }

    public void setProccessor(Proccessor proccessor) {
        this.proccessor = proccessor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    // -------------------------------------------------------------------
    public Integer getMemorySize(){
        if(memory!=null)
            return memory.capacity;
        else
            return 0; // nebo vyhodíme chybu (exception)
    }

}
