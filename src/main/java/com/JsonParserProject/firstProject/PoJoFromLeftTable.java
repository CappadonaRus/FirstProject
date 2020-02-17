package com.JsonParserProject.firstProject;

public class PoJoFromLeftTable {

    private String fio;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String card;
    private String sessionType;
    public Document document = new Document();

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }


    static class Document {

        private String type;
        private String series;
        private String number;
        private String seriesNumber;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getSeriesNumber() {
            return seriesNumber;
        }

        public void setSeriesNumber(String seriesNumber) {
            this.seriesNumber = seriesNumber;
        }
    }
}

//TestParseInnerJson testParseInnerJson = null;
//альтернативный вариант парсинга в 2 мапы с использованием POJO классов TestNewParseJsonValues и TestPArseInnerJson(для вложенного джисона)
// в методе convertClientsDetails

// TestNewParseJsonValues testNewParseJsonValues = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), TestNewParseJsonValues.class);
// Iterator<Map.Entry<String, Object>> iterator2 = testNewParseJsonValues.getClientsMap().entrySet().iterator();
                    /*
                      while (iterator2.hasNext()) {
                        Map.Entry<String, Object> pair2 = iterator2.next();
                        if (pair2.getKey().contains("document")) {
                             testParseInnerJson = objectMapper.readValue(objectMapper.writeValueAsString(pair2.getValue()), TestParseInnerJson.class);
                            testParseInnerJson.printClientsData();
                        }
                    }
                     */
//    splitPaneCreate.createSuperMap(testNewParseJsonValues.getClientsMap(),testParseInnerJson.getClientsMap());
//splitPaneCreate.createColumnsNames(testNewParseJsonValues.getClientsMap());

//testNewParseJsonValues.printClientsData();


// разобраться нужно ли это вообще, альтернативный вариант установки имен столбцов
       /*
        ArrayList<String> setColumnsName = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Object> pair2 = iterator2.next();
            if(pair2.getKey().equalsIgnoreCase("КЛЮШКИН")) {
                try {
                    setColumnsName.add(objectMapper.writeValueAsString(pair2.getValue().toString()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
       // splitPaneCreate.createColumnsNames(setColumnsName);

         */
