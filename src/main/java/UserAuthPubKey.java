import com.jcraft.jsch.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAuthPubKey {
    public static void main(String[] arg) {
        try {
            JSch jsch = new JSch();

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choose your private key (ex. ~/.ssh/id_dsa)");
            chooser.setFileHidingEnabled(false);
            int returnVal = chooser.showOpenDialog(null);
            String privateKey = "-----BEGIN RSA PRIVATE KEY-----\nNIIEpAIBAAKCAQEAp9J2NnjxCPUSs2J3T78O3Z8GRVMhuF94BKngtmfp1jaBX3/9\nBfgrvop/K3FjBxdDrVedQKGbdehlK0er+X49Gy00Jd8qatykKNA3VO3A8uLV51RZ\nDunhiy9c1ZURzWNcYGA196lDLg2zlaB1DtYR3EP4biHhc0qM2x/atOtj/nvB7+aS\nTI5S8LZyzuf0d8m0iPiC9/jgRMipzP7UXb0Rneed/+OW508IUkKs5VkCh52bV2/S\ntQ2b5WTXdg0zSU9n8e4Cd317ETbD4l6m7Ub66w7POCMGRJSzeyH/D6ZAEXo5WOdV\nsCeHcesKVQXL2GkkO9w7UBhjlh5V0TOffQHH3QIDAQABAoIBADL1WSfZOXd60x7d\nO1VfsmfhLcpHH+oYMx1XaAB7NSnyiv4wouf5H29QJqVOXL9+dPJhtEI30DjRREcM\nEFBF4NArvbXyObMRJFewQdzsBLa74i/IEPLSWcYlr467IRi4nwg0rq5xGxEU3/8D\nJghHQE0d5oWqjAayEGtJFOPyxf4znwUQOkSQ9nuDVSlZgqT+rykJgBToHl2+qqmH\n0oIYrfjFhSTIKpGqI25rlNUi5Ug0vLgOLhjcbKqm6hZZpd0CARCsCDZPKvnjZmqq\nsgenf0JOJ06VPEHeyPngAaPuASzzHzSIHfhoCnKjuTTKc8iJc9sHgcjN2Upriz61\nkgdRfoECgYEA7M45wb060vinXoql1Q2eAhc+xE301/6AgUXwYH4T9kWk+xwbKigq\n7NwV0dHQGWz7eogAoU6d74mq4LzYYlKVrv8IMozRNNVrqx6kf22tjymOzJMCMYn0\nftQFfA2oRuBj6ZZbYTPmNJn9djGZUJ3sk+OfxC3J6q7emHeJY32mqNkCgYEAtWzP\n9/dHoB+oXJtXUryjvrHVNWWGBdUC1xFx0O9qvV12yhIT3pka4d+s5B+hed1stB9P\naoeyV566rLYsejldR0v0xl3x+4EGN5zCez2chbf2V2K9ymXI+YUV4UdCFrCyiK0Z\nBMpkliqkt5X42XWysR3kTv5KiNoDg2FfgkbWFKUCgYEAvdQziJNg7G5X/Pm4Jipc\nV+C6eDLl66Ag84BVSYTIC8uYjZPiUtEQV/+1nhVLdJZgocEUgDq9cKAzUyUPcQIy\n662VrLAlpOzQ+sP9qgkJ8JGn32aZg4zLakAchW2NUAPhFAdsCWfJSrGG9ZCdDnsK\ngyMdl+38xxyXZDGu+Qpo50ECgYBws8/dsneEOSZVoQp2E0mFROO18AN5zAGfqO6T\nZKdiS5VnoiNFvMa+Wj0E2cFt+ud0XZ7wBqv7UleUwvaOVuRjTgQY1nNkUZqTIYaP\nGI8LYmRdlLFh8ikPGGWnNKURg2LlFOLd3vztbEA266tTK5J+BJu3lrCmowhbrTmv\nrGGBIQKBgQDBTb3sXxbvnPApfGEkqNuX8p9SgULlrrAlIvYH6FsnOUBk2NUFVKOm\nBizF0tO9KqHpG/eUfXIJIx0pHjPPGM6eSkaBdqMDuurn4Fj5PwPkvX6vmVHOAqA2\nXAZM/ZKonBem27zy4KX1+mq1ynzpo89TleS2nmsDasEHZkJQ7Yal/g==\n-----END RSA PRIVATE KEY-----";
            String ed25519Key = "-----BEGIN OPENSSH PRIVATE KEY-----\nb3BlbnNzaC1rZXktdjEAAAAABG5vbmUAAAAEbm9uZQAAAAAAAAABAAAAMwAAAAtzc2gtZW\nQyNTUxOQAAACAVpWoRAPeI+tmt+N126RRVv0Qpr7c1DbOQC0PEyrpYBAAAAKBSikVGUopF\nRgAAAAtzc2gtZWQyNTUxOQAAACAVpWoRAPeI+tmt+N126RRVv0Qpr7c1DbOQC0PEyrpYBA\nAAAEApwj4WMGKAdBbXah/+AodtwyEhjt3fy3ilN7OmX0exdBWlahEA94j62a343XbpFFW/\nRCmvtzUNs5ALQ8TKulgEAAAAF3VidW50dUBpcC0xNzItMzEtMTgtMTE1AQIDBAUG\n-----END OPENSSH PRIVATE KEY-----";
            String rsa2048 = "-----BEGIN OPENSSH PRIVATE KEY-----\nb3BlbnNzaC1rZXktdjEAAAAABG5vbmUAAAAEbm9uZQAAAAAAAAABAAABFwAAAAdzc2gtcn\nNhAAAAAwEAAQAAAQEApBzjGOa7MPOXMNTSIG1yAsC9nPTbuQe9LYKsnF+u/4aohavS0hqP\nIpGnBBuPE0rIgU0w80VlwwFpKuG3iM99lbkm/3XQeB6oVdy8jrhIpSexMOKWrr0pIFhqwy\nMmA0OdX7MG8iCkoxoFr1VXAGqSTKT/SpPKDXoR7qR+ZLcXWS3Ehk1sa2nnIRWJTR3qhH9X\n7I9Y/jKo9Qc7KTcBl65i+Xyzp4XbaN50uL2x0jPV4mjH1Rmmx1xCPjAeawe8H9MobV+U4W\n08mYzKww73yYFFHinEYvCHuiwIGqPRzd2VQLqCM/37ZMQQK/LifBd3uoJqApUAXtT8C9Ok\nQ6tvqrpwRwAAA9CzVf8qs1X/KgAAAAdzc2gtcnNhAAABAQCkHOMY5rsw85cw1NIgbXICwL\n2c9Nu5B70tgqycX67/hqiFq9LSGo8ikacEG48TSsiBTTDzRWXDAWkq4beIz32VuSb/ddB4\nHqhV3LyOuEilJ7Ew4pauvSkgWGrDIyYDQ51fswbyIKSjGgWvVVcAapJMpP9Kk8oNehHupH\n5ktxdZLcSGTWxraechFYlNHeqEf1fsj1j+Mqj1BzspNwGXrmL5fLOnhdto3nS4vbHSM9Xi\naMfVGabHXEI+MB5rB7wf0yhtX5ThbTyZjMrDDvfJgUUeKcRi8Ie6LAgao9HN3ZVAuoIz/f\ntkxBAr8uJ8F3e6gmoClQBe1PwL06RDq2+qunBHAAAAAwEAAQAAAQBRib61hRH1aNmyG9NI\n5EfUoVG0NZ4jqPovrfC4AvxOHegF/hBRbnu2V7qtGko0ch/7yk/rVowQXteTRDFtqnXBmY\nwMOct5mvXVL0aJ/Hqvf/CUEsh+CiLwXK2yxXhh/8qlnSvyyhAyrz+q1RJUdR66MPJcaeBm\nYMOfF6BqxuM1XXEuO8cOFhi41Q7L5t7cA4QDAqGbPtvJJ24mMcjb94ZxzuAWXDhpAR7LnJ\nN48+w58laT1lQlYofrQAkQCUsRL++dX51UM2ARCpGz7E6bGg5sldq55RZXYc7/ZTEQ2RVa\nkvMk1zFhyEXTg2pTean1PqkuOxL0mMsPkZ3rlrYdaCKFAAAAgGY2HauTZrZEQZXNYIp4R5\nANa7I/6ucAlaxnM5Q/MRIqV8D+MhPdQv2OeQAL9QuFwUDDZ2UgzBtZUyOyy2ZlF9lyeGI6\n88CmPUY6kZ7z9BhX8rnMJJpApNIJdh5eYbdNFnUjHo14gfYGE8nwx5uuP1yUcYqOdqcsdr\ncFRrK4HPF1AAAAgQDdmQ4H9K+0I3VN659SYqAnfoypIv0fTXVnaua/2e81+ff84K4fjisV\nc3CaurPuyqHAw6Smyr4/qPzkHn4McTymV7OFcSKsexAXXnJj54o6euV33CcxB6NEFbcEk2\nHjf1wnQzdYgTgzkt2SpYviw5hbVEQJLMJ2MnpYcmAOEHHMLQAAAIEAvZc1rDS9cJoqNroR\nJwyrO47pevUdZqcTmX8YZoWUy84NRUpJLFKx5UoMAOusaIjdVwQVnSK3HnumGP2ouIrr9l\neb+hY21cIAORZQPawQwxSKfCIXQu+3Kx7ZPsGOTmC617Z87YgD4wPdGHdvKT9RoOt1GBvU\nI+SYFSGoxNsr0sMAAAAVcm9vdEBpcC0xNzItMzEtMTgtMTE1AQIDBAUG\n-----END OPENSSH PRIVATE KEY-----";
            String rsa4096 = "-----BEGIN OPENSSH PRIVATE KEY-----\n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\n-----END OPENSSH PRIVATE KEY-----";
            String rsa1024 = "-----BEGIN OPENSSH PRIVATE KEY-----\nb3BlbnNzaC1rZXktdjEAAAAABG5vbmUAAAAEbm9uZQAAAAAAAAABAAAAlwAAAAdzc2gtcn\nNhAAAAAwEAAQAAAIEAvHkSdAdcIikMGrGyC7M5Fgto9WMEKXZpjpXtxhrQkcTOLC1pF2KY\nVcbgC1e5wLamTWr5eY9yhTlN+UKh3xxpLcaaSfrPU3kZX7+3xv8xFtHlDFtLdg+R0+Df8T\n6zW1Dsu6rMZRDTERhRQksJ0bJ2wXOmlQrkWljcBCKoqu4YBCEAAAIQa82fM2vNnzMAAAAH\nc3NoLXJzYQAAAIEAvHkSdAdcIikMGrGyC7M5Fgto9WMEKXZpjpXtxhrQkcTOLC1pF2KYVc\nbgC1e5wLamTWr5eY9yhTlN+UKh3xxpLcaaSfrPU3kZX7+3xv8xFtHlDFtLdg+R0+Df8T6z\nW1Dsu6rMZRDTERhRQksJ0bJ2wXOmlQrkWljcBCKoqu4YBCEAAAADAQABAAAAgBmiliH2Bl\nAXKTBQTxlMTU10S9hkmWJSWtUsC2VQrGHHVQupOYwWuwWfwUWJrxhJP6F0FW61VixMuRBY\nQdAo+x0k/8BU/XHGLIPYfldGnY+1TupOJu0x1W2lYMByg4JXvejle4riq8ejJys6uTS2h2\nVe4KlB6E2h/YL92HyABJpJAAAAQQCWifuZUknpHM1yWttubuTChXmQ8cyqw/iSteeK7mFx\n9wd9ypAP2Zy75oKI6yksMMRscb8gZltx9tlxe+w+2yN4AAAAQQDlw4dMkdgxEGckHgLfOW\nr2vXwG+BqmfpWmQ9vURkQ4lAeGagVJrn2HN+YWqdYscVdgRFyNrIfCEVyTEPHqAWoXAAAA\nQQDR/obPKI1intNb9EtrtCw0VmL6+XxbnemoTep5MFqbH/6KnGAsgFpjszmSniV173nc/T\n3Bz7OBvI3Y5fFnxL6HAAAAF3VidW50dUBpcC0xNzItMzEtMTgtMTE1AQID\n-----END OPENSSH PRIVATE KEY-----";

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File privateKeyFile = chooser.getSelectedFile();
                String privateKeyPath = privateKeyFile.getAbsolutePath();
                System.out.println("You chose " + privateKeyPath + ".");

                // Read passphrase from the user
                JPasswordField passphraseField = new JPasswordField(20);
                Object[] ob = {passphraseField};
                int result = JOptionPane.showConfirmDialog(null, ob,
                        "Enter passphrase (empty for no passphrase)", JOptionPane.OK_CANCEL_OPTION);
                String passphrase = null;
                if (result == JOptionPane.OK_OPTION) {
                    passphrase = new String(passphraseField.getPassword());
                }
                byte[] privateKeyBytes = rsa1024.getBytes();

                jsch.addIdentity("key", privateKeyBytes, null, null);
            }

            String host = null;
            if (arg.length > 0) {
                host = arg[0];
            } else {
                host = JOptionPane.showInputDialog("Enter username@hostname",
                        System.getProperty("user.name") + "@localhost");
            }
            String user = host.substring(0, host.indexOf('@'));
            host = host.substring(host.indexOf('@') + 1);

            Session session = jsch.getSession(user, host, 22);

            // Username and passphrase will be given via UserInfo interface.
            UserInfo ui = new MyUserInfo();
            session.setUserInfo(ui);
            session.connect();

            Channel channel = session.openChannel("shell");

            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);

            channel.connect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static class MyUserInfo implements UserInfo, UIKeyboardInteractive {
        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public boolean promptYesNo(String str) {
            Object[] options = {"yes", "no"};
            int foo = JOptionPane.showOptionDialog(null, str, "Warning", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            return foo == 0;
        }

        String passphrase;
        JTextField passphraseField = new JPasswordField(20);

        @Override
        public String getPassphrase() {
            return passphrase;
        }

        @Override
        public boolean promptPassphrase(String message) {
            Object[] ob = {passphraseField};
            int result = JOptionPane.showConfirmDialog(null, ob, message, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                passphrase = passphraseField.getText();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean promptPassword(String message) {
            return true;
        }

        @Override
        public void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message);
        }

        final GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
        private Container panel;

        @Override
        public String[] promptKeyboardInteractive(String destination, String name, String instruction,
                                                  String[] prompt, boolean[] echo) {
            panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            gbc.weightx = 1.0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.gridx = 0;
            panel.add(new JLabel(instruction), gbc);
            gbc.gridy++;

            gbc.gridwidth = GridBagConstraints.RELATIVE;

            JTextField[] texts = new JTextField[prompt.length];
            for (int i = 0; i < prompt.length; i++) {
                gbc.fill = GridBagConstraints.NONE;
                gbc.gridx = 0;
                gbc.weightx = 1;
                panel.add(new JLabel(prompt[i]), gbc);

                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.weighty = 1;
                if (echo[i]) {
                    texts[i] = new JTextField(20);
                } else {
                    texts[i] = new JPasswordField(20);
                }
                panel.add(texts[i], gbc);
                gbc.gridy++;
            }

            if (JOptionPane.showConfirmDialog(null, panel, destination + ": " + name,
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                String[] response = new String[prompt.length];
                for (int i = 0; i < prompt.length; i++) {
                    response[i] = texts[i].getText();
                }
                return response;
            } else {
                return null; // cancel
            }
        }
    }
}
