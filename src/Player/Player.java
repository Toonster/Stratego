package Player;

import army.unit.Unit;
import common.Position;

import java.util.List;

public class Player {

    public Position selectUnitPosition(){
        Unit unit = null;
        return unit.getPosition();
    }

   /* public Position selectDestination(){
        Unit unit = null;
        return unit.;
    }*/

  /* public Unit selectUnitToPlace(List<Unit> units){
       Unit unit = null;
       return units.addAll(unit.place(unit.getPosition()));
   }*/

  public boolean useStandardArmyConfig(){
      Human human = new Human();
      Computer computer = new Computer();
      if (human.input.equals("Yes")){
          return true;
      }
      return false;
  }
}
