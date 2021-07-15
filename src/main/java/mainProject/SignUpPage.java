package mainProject;

public class SignUpPage extends BaseClass {


    public void titleDropdownList() {
        getDropDownListByValue(Locators.TITLE_SELECT, Data.select);
    }

    public void sendKeysFirstNameAndSurname() {
        setText(Locators.FIRST_NAME_INPUT, Data.name);
        setText(Locators.SURNAME_INPUT, Data.surname);
    }

    public void clickCheckbox() {
        clickUnselectedCheckbox(Locators.CHECKBOX);
    }

}
