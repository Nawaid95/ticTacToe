package dev.nawaid.Models;

public class HumanPlayer extends Player {
    private User user;

    @Override
    public void makeMove(Board board) {

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private HumanPlayer humanPlayerObj;

        public Builder() {
            this.humanPlayerObj = new HumanPlayer();
        }

        public Builder setUser(User user) {
            this.humanPlayerObj.user = user;
            return this;
        }

        public Builder setSymbol(char symbol) {
            this.humanPlayerObj.symbol = new Symbol(symbol);
            return this;
        }

        public HumanPlayer build() {
            return this.humanPlayerObj;
        }
    }
}
