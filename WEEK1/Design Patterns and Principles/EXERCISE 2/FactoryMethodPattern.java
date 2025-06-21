
interface Doc {
    void show();
}

class WordDoc implements Doc {
    public void show() {
        System.out.println("Showing Word doc");
    }
}

class PDFDoc implements Doc {
    public void show() {
        System.out.println("Showing PDF doc");
    }
}

class DocMaker {
    Doc makeDoc(String type) {
        if (type.equals("word")) {
            return new WordDoc();
        }
        else if (type.equals("pdf")) {
            return new PDFDoc();
        }
        return null;
    }
}

class TestDocs {
    public static void main(String[] a) {
        DocMaker maker = new DocMaker();
        Doc d1 = maker.makeDoc("word");
        Doc d2 = maker.makeDoc("pdf");
        
        d1.show();
        d2.show();
    }
}