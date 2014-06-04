package com.ouchadam.jogame.domain;

public class Buildable {

    public enum Type {
        METAL_MINE {
            @Override
            public String label() {
                return "Metal Mine";
            }
        },
        CRYSTAL_MINE {
            @Override
            public String label() {
                return "Crystal Mine";
            }
        },
        DEUTERIUM_SYNTHESIZER {
            @Override
            public String label() {
                return "Deuterium Synthesizer";
            }
        },
        SOLAR_PLANT {
            @Override
            public String label() {
                return "Solar Plant";
            }
        },
        FUSION_REACTOR {
            @Override
            public String label() {
                return "Fusion Reactor";
            }
        },
        SOLAR_SATELLITE {
            @Override
            public String label() {
                return "Solar Satellite";
            }
        },
        METAL_STORAGE {
            @Override
            public String label() {
                return "Metal Storage";
            }
        },
        CRYSTAL_STORAGE {
            @Override
            public String label() {
                return "Crystal Storage";
            }
        },
        DEUTERIUM_TANK {
            @Override
            public String label() {
                return "Deuterium Tank";
            }
        },
        SHIELDED_METAL_DEN {
            @Override
            public String label() {
                return "Shielded Metal Den";
            }
        },
        UNDERGROUND_CRYSTAL_DEN {
            @Override
            public String label() {
                return "Underground Crystal Den";
            }
        },
        SEABED_DEUTERIUM_DEN {
            @Override
            public String label() {
                return "Seabed Deuterium Den";
            }
        },
        ROBOTICS_FACTORY {
            @Override
            public String label() {
                return "Robotics Factory";
            }
        },
        SHIPYARD {
            @Override
            public String label() {
                return "Shipyard";
            }
        },
        RESEARCH_LAB {
            @Override
            public String label() {
                return "Research Lab";
            }
        },
        ALLIANCE_DEPOT {
            @Override
            public String label() {
                return "Alliance Depot";
            }
        },
        MISSILE_SILO {
            @Override
            public String label() {
                return "Missle Silo";
            }
        },
        NANITE_FACTORY {
            @Override
            public String label() {
                return "Nanite Factory";
            }
        },
        TERRAFORMER {
            @Override
            public String label() {
                return "Terraformer";
            }
        };

        public abstract String label();

        public static Type from(String name) {
            return valueOf(name.replace(' ', '_').toUpperCase());
        }
    }

    public static final String NO_UPGRADE_LINK = "NO_UPGRADE_LINK";

    private final Type type;
    private final int level;
    private final Status status;
    private final String upgradeLink;

    public Buildable(Type type, int level, Status status, String upgradeLink) {
        this.type = type;
        this.level = level;
        this.status = status;
        this.upgradeLink = upgradeLink;
    }

    public String getName() {
        return type.label();
    }

    public Type getResource() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public String getUpgradeLink() {
        return upgradeLink;
    }

    private boolean hasUpgradeLink() {
        return !NO_UPGRADE_LINK.equals(upgradeLink);
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + type.label() + '\'' +
                "type='" + type + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", hasUpgradeLink='" + hasUpgradeLink() + '\'' +
                '}';
    }
}
