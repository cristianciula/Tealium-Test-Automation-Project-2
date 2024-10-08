package testdata.DataProviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static testdatafiles.UserData.*;

public class UserDataProviders {

    //TODO: Need to update to hold User data in a centralized location (CSV, Excel, JSON, DB)

    /* -------------------- EMAIL DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmail")
    public Object[][] validEmail() {
        return new Object[][] {
                {EMAIL.getValue()}
        };
    }

    @DataProvider (name = "wrongEmail")
    public Object[][] wrongEmail() {
        return new Object[][] {
                // Email not associated to an account
                {"wrong@example.com"}
        };
    }

    @DataProvider (name = "emptyEmail")
    public Object[][] emptyEmail() {
        return new Object[][] {
                {""}
        };
    }

    @DataProvider (name = "invalidEmailSyntax")
    public Object[][] invalidEmailSyntax() {
        return new Object[][] {
                {"@example.com"},
                {"user@example."},
                {"user@examplecom"},
                {"user@.com"},
                {"user@com"},
                {"userexample.com"},
                {"user@example.c"}
        };
    }

    @DataProvider (name = "wrongAndEmptyEmail")
    public Object[][] wrongAndEmptyEmail() {

                Object[][] data1 = wrongEmail();
                Object[][] data2 = emptyEmail();

        return Stream.of(data1, data2)
                        .flatMap(Arrays::stream)
                        .toArray(Object[][]::new);
    }

    /* -------------------- PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {PASSWORD.getValue()}
        };
    }

    @DataProvider (name = "wrongPassword")
    public Object[][] wrongPassword() {
        return new Object[][] {
                {"Qwerty123!"}
        };
    }

    @DataProvider (name = "emptyPassword")
    public Object[][] emptyPassword() {
        return new Object[][] {
                {""}
        };
    }

    @DataProvider (name = "invalidPasswordSyntax")
    public Object[][] invalidPasswordSyntax() {
        return new Object[][] {
                {"P"},
                {"123"},
                {"P123"},
                {"ParolaParola"},
                {"ParolaParola100"},
                {"ParolaParola!"},
                {"1234567890"},
                {"1234567890!"}
        };
    }

    @DataProvider (name = "wrongAndEmptyPassword")
    public Object[][] wrongAndEmptyPassword() {

        Object[][] data1 = wrongPassword();
        Object[][] data2 = emptyPassword();

        return Stream.of(data1, data2)
                .flatMap(Arrays::stream)
                .toArray(Object[][]::new);
    }

    /* -------------------- COMBINED EMAIL & PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmailValidPassword")
    public Object[][] validEmailValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailInvalidPassword")
    public Object[][] validEmailInvalidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = wrongAndEmptyPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailValidPassword")
    public Object[][] invalidEmailValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = wrongAndEmptyEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailInvalidPassword")
    public Object[][] invalidEmailInvalidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = wrongAndEmptyEmail();
        Object[][] dataProvider2 = wrongAndEmptyPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "wrongEmailValidPassword")
    public Object[][] wrongEmailValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = wrongEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailWrongPassword")
    public Object[][] validEmailWrongPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = wrongPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailSyntaxValidPassword")
    public Object[][] invalidEmailSyntaxValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = invalidEmailSyntax();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

//    @DataProvider (name = "validEmailInvalidPasswordSyntax")
//    public Object[][] validEmailInvalidPasswordSyntax() {
//
//        //Prerequisites
//        Object[][] dataProvider1 = validEmail();
//        Object[][] dataProvider2 = invalidPasswordSyntax();
//        List<Object[]> combinedDataProviders = new ArrayList<>();
//
//        //Combine the data
//        for (Object[] dataProvider1Obj : dataProvider1) {
//            for (Object[] dataProvider2Obj : dataProvider2) {
//                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
//                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
//                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
//                combinedDataProviders.add(combinedItem);
//            }
//        }
//        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
//    }

//

//    @DataProvider (name = "invalidEmailSyntaxValidPassword")
//    public Object[][] invalidEmailSyntaxValidPassword() {
//
//        //Prerequisites
//        Object[][] dataProvider1 = invalidEmailSyntax();
//        Object[][] dataProvider2 = validPassword();
//        List<Object[]> combinedDataProviders = new ArrayList<>();
//
//        //Combine the data
//        for (Object[] dataProvider1Obj : dataProvider1) {
//            for (Object[] dataProvider2Obj : dataProvider2) {
//                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
//                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
//                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
//                combinedDataProviders.add(combinedItem);
//            }
//        }
//        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
//    }

    /* -------------------- USER NAMES DATA PROVIDERS -------------------- */

    @DataProvider (name = "validFirstName")
    public Object[][] validFirstName() {
        return new Object[][] {
                {FIRST_NAME.getValue()}
        };
    }

    @DataProvider (name = "validMiddleName")
    public Object[][] validMiddleName() {
        return new Object[][] {
                {MIDDLE_NAME.getValue()}
        };
    }

    @DataProvider (name = "validLastName")
    public Object[][] validLastName() {
        return new Object[][] {
                {LAST_NAME.getValue()}
        };
    }

    @DataProvider (name = "validFirstAndLastName")
    public Object[][] validNames() {
        return new Object[][] {
                {FIRST_NAME.getValue(), MIDDLE_NAME.getValue(), LAST_NAME.getValue()}
        };
    }

}