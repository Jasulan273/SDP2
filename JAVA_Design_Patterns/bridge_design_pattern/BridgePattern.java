package bridge_design_pattern;

// Define an abstract class 'TV' that contains a 'Remote' reference and abstract methods 'on' and 'off'.
abstract class TV {
    Remote remote;
    TV(Remote r) {
        this.remote = r;
    }
    abstract void on();
    abstract void off();
}

// Create a 'Sony' TV class that extends 'TV' and specifies a 'Remote' type.
class Sony extends TV {
    Remote remoteType;
    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

//Create a Philips TV class that extends TV and specifies a Remote type
class Philips extends TV {
    Remote remoteType;
    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

//Define the Remote interface with on and off methods
interface Remote {
    public void on();
    public void off();
}

//Create an OldRemote class that implements the Remote interface for old remote control
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

//Create a NewRemote class that implements the Remote interface for new remote control
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

//Main class to demonstrate the BDP
public class BridgePattern {
    public static void main(String[] args) {
        // Create a 'Sony' TV with an 'OldRemote' and perform 'on' and 'off' actions.
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        //Create a SonyTV with a NewRemote and perform on and off actions
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        //Create Philips TV with an OldRemote and perform on and off actions
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        //Create Philips TV with a NewRemote and perform on and off actions.
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
