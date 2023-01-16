package Facade;

import ReadingAndWriting.*;

public class Facade {

    public file getFile(FileType type) {
        file toReturn = null;
        switch (type) {
            case TXT:
                toReturn = new TXT();
                break;
            case JSON:
                toReturn = new JSON();
                break;
            case XML:
                toReturn = new XML();
                break;
            default:
                throw new IllegalArgumentException("Wrong file type:" + type);
        }
        return toReturn;
    }
}