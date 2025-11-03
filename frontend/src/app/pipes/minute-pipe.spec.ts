import { MinutePipe } from './minute-pipe';

describe('TimePipe', () => {
  it('create an instance', () => {
    const pipe = new MinutePipe();
    expect(pipe).toBeTruthy();
  });
});
