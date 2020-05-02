public class Position {
    byte positionID;
    String positionName;

    public Position() {

    }
    public Position(byte positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public byte getPositionID() {
        return positionID;
    }

    public void setPositionID(byte positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
