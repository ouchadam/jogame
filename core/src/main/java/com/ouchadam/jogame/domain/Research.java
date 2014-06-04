package com.ouchadam.jogame.domain;

public class Research {

    private final Type type;
    private final int level;
    private final Status status;
    private final int id;

    public enum Type {
        ENERGY_TECHNOLOGY {
            @Override
            public String label() {
                return "Energy Technology";
            }
        },
        LASER_TECHNOLOGY {
            @Override
            public String label() {
                return "Laser Technology";
            }
        },
        ION_TECHNOLOGY {
            @Override
            public String label() {
                return "Ion Technology";
            }
        },
        HYPERSPACE_TECHNOLOGY {
            @Override
            public String label() {
                return "Hyperspace Technology";
            }
        },
        PLASMA_TECHNOLOGY {
            @Override
            public String label() {
                return "Plasma Technology";
            }
        },
        COMBUSTION_DRIVE {
            @Override
            public String label() {
                return "Combustion Drive";
            }
        },
        IMPULSE_DRIVE {
            @Override
            public String label() {
                return "Impulse Drive";
            }
        },
        HYPERSPACE_DRIVE {
            @Override
            public String label() {
                return "Hyperspace Drive";
            }
        },
        ESPIONAGE_TECHNOLOGY {
            @Override
            public String label() {
                return "Espionage Technology";
            }
        },
        COMPUTER_TECHNOLOGY {
            @Override
            public String label() {
                return "Computer Technology";
            }
        },
        ASTROPHYSICS {
            @Override
            public String label() {
                return "Astrophysics";
            }
        },
        INTERGALACTIC_RESEARCH_NETWORK {
            @Override
            public String label() {
                return "Intergalactic Research Network";
            }
        },
        GRAVITON_TECHNOLOGY {
            @Override
            public String label() {
                return "Graviton Technology";
            }
        },
        WEAPONS_TECHNOLOGY {
            @Override
            public String label() {
                return "Weapons Technology";
            }
        },
        SHIELDING_TECHNOLOGY {
            @Override
            public String label() {
                return "Shielding Technology";
            }
        },
        ARMOUR_TECHNOLOGY {
            @Override
            public String label() {
                return "Armour Technology";
            }
        };

        public abstract String label();

        public static Type from(String name) {
            return valueOf(name.replace(' ', '_').toUpperCase());
        }
    }

    public Research(Type type, int level, Status status, int id) {
        this.type = type;
        this.level = level;
        this.status = status;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Research{" +
                "type=" + type +
                ", level=" + level +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
